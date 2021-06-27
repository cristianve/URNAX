package com.redgroup.votox
package Domain.Services.Repositories

import Domain.PoliticalParty

trait PoliticalPartyRepository {

  def Get(id: Int): PoliticalParty

  def Update(politicalParty: PoliticalParty)

}
