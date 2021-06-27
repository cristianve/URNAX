package com.redgroup.votox
package Infrastructure.Repository.CompanionObjects

import Domain.Direction

import io.circe.{Decoder, HCursor, Json}

/**
 * Companion object utilizado para poder deserizar mediante la libreria circe correctamente y poder construir nuestro objecto de dominio sin problemas
 * Como se puede ver no lo hemos puesto en el mismo fichero que nuestra case class Person ya que al utilizar implementacion custom utilizando la libreria circe esto ya pasa a ser algo de infrastructura y no de dominio
 */
object Person {
  // here we are actually casting the return value to Decode
  implicit val decoder: Decoder[Domain.Person] = (hCursor: HCursor) =>
    for {
      id <- hCursor.downField("id").as[Int]
      name <- hCursor.get[String]("name")
      surname <- hCursor.get[String]("surname")
      nif <- hCursor.get[String]("nif")
      email <- hCursor.get[String]("email")
      direction <- hCursor.downField("direction").as[Json]
      city <- direction.hcursor.get[String]("city")
      state <- direction.hcursor.get[String]("state")
      postalCode <- direction.hcursor.get[String]("postalCode")
      hasVoted <- hCursor.downField("hasVoted").as[Boolean]
    } yield Domain.Person(id, name, surname, nif, email, Direction(city, state, postalCode), hasVoted)
}
