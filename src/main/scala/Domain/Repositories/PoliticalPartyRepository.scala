package com.redgroup.votox
package Domain.Repositories

import Domain.PoliticalParty

/**
 * Trait que nos permite definir la estructura de nuestro repositorio, así como el tipo de contrato especificando los valores esperados y funciones a implemntar.
 */
trait PoliticalPartyRepository {

  def Get(id: Int): PoliticalParty

  def GetAll(): List[PoliticalParty]

  def Update(politicalParty: PoliticalParty)

}
