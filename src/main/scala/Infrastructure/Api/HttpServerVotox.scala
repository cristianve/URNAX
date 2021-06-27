package com.redgroup.votox
package Infrastructure.Api

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import com.redgroup.votox.Application.Dto.VoteDto
import com.redgroup.votox.Application.VoteApplicationService
import com.redgroup.votox.Domain.Exceptions.{UserAlreadyVotedException, UserNotExistException}
import com.redgroup.votox.Domain.Services.{ValidationService, VoteService}
import com.redgroup.votox.Infrastructure.Repository.PersonJsonRepository

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object HttpServerVotox {


  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "Request")
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  def main(args: Array[String]): Unit = {

    val route =
      path("vote") {
        post {
          parameter("idPerson", "idPoliticalParty") {
            (idPerson, idPoliticalParty) =>

              val vote = VoteDto(idPerson.toInt, idPoliticalParty.toInt)
              val applicationService = new VoteApplicationService(validationService = new ValidationService(new PersonJsonRepository), voteService = new VoteService(new PersonJsonRepository))


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

    val port = 9001
    val bindingFuture = Http().newServerAt("localhost", port).bind(route)

    println(s"Server online at http://localhost:$port/vote\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}



