package com.redgroup.votox
package Infrastructure.Repository.CompanionObjects

import Domain.Direction

import io.circe.{Decoder, HCursor, Json}

object Person {
  // here we are actually casting the return value to Decode
  implicit val decoder: Decoder[Domain.Person] = (hCursor: HCursor) =>
    for {
      id <- hCursor.downField("id").as[Int]
      name <- hCursor.get[String]("name")
      surname <- hCursor.get[String]("surname")
      nif <- hCursor.get[String]("nif")
      direction <- hCursor.downField("direction").as[Json]
      city <- direction.hcursor.get[String]("city")
      state <- direction.hcursor.get[String]("state")
      postalCode <- direction.hcursor.get[String]("postalCode")
      hasVoted <- hCursor.downField("hasVoted").as[Boolean]
    } yield Domain.Person(id, name, surname, nif, Direction(city, state, postalCode), hasVoted)
}
