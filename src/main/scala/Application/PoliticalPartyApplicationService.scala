package com.redgroup.votox
package Application

import Domain.PoliticalParty
import Domain.Services.Repositories.PoliticalPartyRepository

class PoliticalPartyApplicationService(politicalPartyRepository: PoliticalPartyRepository) {

  def Execute(): List[PoliticalParty] = {

    politicalPartyRepository.GetAll()

  }

}
