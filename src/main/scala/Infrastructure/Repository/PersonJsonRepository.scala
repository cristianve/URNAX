package com.redgroup.votox
package Infrastructure.Repository

import Domain.Person
import Domain.Services.Repositories.PersonRepository

import io.circe._
import io.circe.generic.auto._

import scala.io.BufferedSource

class PersonJsonRepository extends PersonRepository {

  val path: String = getClass.getResource("people.json").getPath;
  val source: BufferedSource = scala.io.Source.fromFile(path)

  override def Get(id: Int): Person = {

    val lines = try source.mkString finally source.close()

    parser.decode[List[Person]](lines) match {
      case Right(persons) => persons.find(p => {p.id == id}).orNull
      case Left(ex) => throw Exception
    }
  }

  override def Update(person: Person): Unit = {


  }

}
