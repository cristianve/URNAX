package com.redgroup.votox
package Application

import Domain.PoliticalParty
import Domain.Repositories.PoliticalPartyRepository

class PoliticalPartyApplicationService(politicalPartyRepository: PoliticalPartyRepository) {

  def Execute(): List[PoliticalParty] = {

    politicalPartyRepository.GetAll()

  }

}
