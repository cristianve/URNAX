package com.redgroup.votox
package Infrastructure.Repository.CompanionObjects

import io.circe.{Decoder, HCursor}

object PoliticalParty {
  // here we are actually casting the return value to Decode
  implicit val decoder: Decoder[Domain.PoliticalParty] = (hCursor: HCursor) =>
    for {
      id <- hCursor.downField("id").as[Int]
      name <- hCursor.get[String]("name")
      count <- hCursor.downField("count").as[Int]

    } yield Domain.PoliticalParty(id, name, count)
}
