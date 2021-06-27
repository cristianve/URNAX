package com.redgroup.votox
package Infrastructure.Api.Traits

import Domain.PoliticalParty
import Infrastructure.Api.Dto.PoliticalParties

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

/**
 * Necesario definir este contrato para poder serializar nuestro resultado (lista de partidos politicos) mediante Akka
 */
trait PoliticalPartiesJsonFormatter extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val singleFormat: RootJsonFormat[PoliticalParty] = jsonFormat3(PoliticalParty)
  implicit val ListFormat: RootJsonFormat[PoliticalParties] = jsonFormat1(PoliticalParties)
}
