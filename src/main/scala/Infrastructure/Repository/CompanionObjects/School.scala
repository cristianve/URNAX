package com.redgroup.votox
package Infrastructure.Repository.CompanionObjects

import Domain.Direction

import io.circe.{Decoder, HCursor, Json}

/**
 * Companion object utilizado para poder deserizar mediante la libreria circe correctamente y poder construir nuestro objecto de dominio sin problemas
 * Como se puede ver no lo hemos puesto en el mismo fichero que nuestra case class School ya que al utilizar implementacion custom utilizando la libreria circe esto ya pasa a ser algo de infrastructura y no de dominio
 */
object School {
  // here we are actually casting the return value to Decode
  implicit val decoder: Decoder[Domain.School] = (hCursor: HCursor) =>
    for {
      id <- hCursor.downField("id").as[Int]
      name <- hCursor.get[String]("name")
      direction <- hCursor.downField("direction").as[Json]
      city <- direction.hcursor.get[String]("city")
      state <- direction.hcursor.get[String]("state")
      postalCode <- direction.hcursor.get[String]("postalCode")

    } yield Domain.School(id, Direction(city, state, postalCode), name)
}
