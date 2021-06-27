package com.redgroup.votox
package Domain.Services

import Domain.Services.Repositories.{PersonRepository, PoliticalPartyRepository}

class VoteService(personRepository: PersonRepository, politicalPartyRepository: PoliticalPartyRepository) {

  def Vote(idPerson: Int, idPoliticalParty: Int): Unit = {

    val repoPerson = personRepository.Get(idPerson)

    val repoPoliticalParty = politicalPartyRepository.Get(idPoliticalParty)

    repoPerson.MarkAsVoted(true)

    repoPoliticalParty.UpdateVotes()

    personRepository.Update(repoPerson)
    politicalPartyRepository.Update(repoPoliticalParty)
  }
}
