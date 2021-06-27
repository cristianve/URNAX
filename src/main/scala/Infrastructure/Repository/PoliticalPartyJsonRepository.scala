package com.redgroup.votox
package Infrastructure.Repository

import Domain.PoliticalParty
import Domain.Services.Repositories.PoliticalPartyRepository

import io.circe._
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps

import java.io.PrintWriter
import scala.collection.mutable.ListBuffer
import scala.io.BufferedSource


class PoliticalPartyJsonRepository extends PoliticalPartyRepository {

  val path: String = getClass.getResource("politicalParties.json").getPath;

  override def Get(id: Int): PoliticalParty = {

    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[List[Domain.PoliticalParty]](lines) match {
      case Right(politicalParties) => politicalParties.find(p => {
        p.id == id
      }).orNull
      case Left(ex) => null
    }
  }

  override def Update(politicalParty: PoliticalParty): Unit = {
    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[ListBuffer[PoliticalParty]](lines) match {
      case Right(politicalParties) =>

        politicalParties -= politicalParties.find(p => {
          p.id == politicalParty.id
        }).orNull

        politicalParties += politicalParty

        val json = politicalParties.asJson

        val writer = new PrintWriter(path) {
          print("")
          write(json.toString())
          close()
        }


      case Left(ex) => null
    }

  }

  override def GetAll(): List[PoliticalParty] = {

    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[List[Domain.PoliticalParty]](lines) match {
      case Right(politicalParties) => politicalParties
      case Left(ex) => null
    }
  }
}
