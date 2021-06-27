package com.redgroup.votox
package Infrastructure.Repository.CompanionObjects

import io.circe.{Decoder, HCursor}

/**
 * Companion object utilizado para poder deserizar mediante la libreria circe correctamente y poder construir nuestro objecto de dominio sin problemas
 * Como se puede ver no lo hemos puesto en el mismo fichero que nuestra case class PoliticalParty ya que al utilizar implementacion custom utilizando la libreria circe esto ya pasa a ser algo de infrastructura y no de dominio
 */
object PoliticalParty {
  // here we are actually casting the return value to Decode
  implicit val decoder: Decoder[Domain.PoliticalParty] = (hCursor: HCursor) =>
    for {
      id <- hCursor.downField("id").as[Int]
      name <- hCursor.get[String]("name")
      count <- hCursor.downField("count").as[Int]

    } yield Domain.PoliticalParty(id, name, count)
}
