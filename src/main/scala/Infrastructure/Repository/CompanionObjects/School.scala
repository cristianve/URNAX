package com.redgroup.votox
package Infrastructure.Repository.CompanionObjects

import Domain.Direction

import io.circe.{Decoder, HCursor, Json}

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
