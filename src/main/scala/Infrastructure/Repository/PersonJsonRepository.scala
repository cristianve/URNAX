package com.redgroup.votox
package Infrastructure.Repository

import Domain.Person
import Domain.Repositories.PersonRepository

import io.circe._
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps

import java.io.PrintWriter
import scala.collection.mutable.ListBuffer
import scala.io.BufferedSource

/**
 * Implementacion custom para trabajar con nuestro Json de personas como BD, implementamos los metodos de nuestro trait
 * Como se puede ver en esta clase utilizamos High Order functions,  funciones anonimas y los tipos scala.Option (mediante el uso del .orNull)
 */
class PersonJsonRepository extends PersonRepository {

  val path: String = getClass.getResource("/people.json").getPath;

  override def Get(id: Int): Person = {

    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[List[Person]](lines) match {
      case Right(persons) => persons.find(p => {
        p.id == id
      }).orNull
      case Left(ex) => null
    }
  }

  override def Update(person: Person): Unit = {
    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[ListBuffer[Person]](lines) match {
      case Right(persons) =>

        persons -= persons.find(p => {
          p.id == person.id
        }).orNull

        persons += person

        val json = persons.asJson

        new PrintWriter(path) {
          print("")
          print(json.toString())
          close()
        }


      case Left(ex) => null
    }

  }

  override def GetAll(): List[Person] = {

    val source: BufferedSource = scala.io.Source.fromFile(path)

    val lines = try source.mkString finally source.close()

    parser.decode[List[Person]](lines) match {
      case Right(persons) => persons
      case Left(ex) => null
    }
  }
}
