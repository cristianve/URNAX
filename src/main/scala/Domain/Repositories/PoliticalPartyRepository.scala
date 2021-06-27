package com.redgroup.votox
package Domain.Repositories

import Domain.PoliticalParty

trait PoliticalPartyRepository {

  def Get(id: Int): PoliticalParty

  def GetAll(): List[PoliticalParty]

  def Update(politicalParty: PoliticalParty)

}
