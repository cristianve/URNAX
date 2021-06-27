package com.redgroup.votox
package Infrastructure.Api

import Application.Dto.VoteDto
import Application.{PoliticalPartyApplicationService, VoteApplicationService}
import Domain.Exceptions.{UserAlreadyVotedException, UserNotExistException}
import Domain.Services.{ValidationService, VoteService}
import Infrastructure.Api.Traits.PoliticalPartiesJsonFormatter
import Infrastructure.Repository.{PersonJsonRepository, PoliticalPartyJsonRepository}

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object HttpServerVotox extends Directives with PoliticalPartiesJsonFormatter {


  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "Request")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  def main(args: Array[String]): Unit = {

    val voteRoute =
      path("vote") {
        post {
          parameter("idPerson", "idPoliticalParty") {
            (idPerson, idPoliticalParty) =>

              val vote = VoteDto(idPerson.toInt, idPoliticalParty.toInt)
              val applicationService = new VoteApplicationService(validationService = new ValidationService(new PersonJsonRepository), voteService = new VoteService(new PersonJsonRepository, new PoliticalPartyJsonRepository))

              try {
                applicationService.Execute(vote)
                complete(StatusCodes.OK)
              }
              catch {
                case e: UserAlreadyVotedException => complete(StatusCodes.Forbidden, e.getMessage)
                case e: UserNotExistException => complete(StatusCodes.NotFound, e.getMessage)
              }
          }

        }
      }


    val scoreRoute =
      path("score") {
        get {
          val applicationService = new PoliticalPartyApplicationService(new PoliticalPartyJsonRepository)
          try {
            complete(StatusCodes.OK, applicationService.Execute())
          }
          catch {
            case e: UserAlreadyVotedException => complete(StatusCodes.Forbidden, e.getMessage)
            case e: UserNotExistException => complete(StatusCodes.NotFound, e.getMessage)
          }
        }

      }

    val routes = voteRoute ~ scoreRoute

    val port = 9001
    val bindingFuture = Http().newServerAt("localhost", port).bindFlow(routes)

    println(s"Server online at http://localhost:$port/vote\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}



