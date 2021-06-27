package com.redgroup.votox
package Domain.Services

import Domain.Services.Repositories.PersonRepository

import com.redgroup.votox.Domain.Person

class VoteService (personRepository: PersonRepository){

  def Vote(idPerson:Int, idPoliticalParty: Int): Unit ={

    val repoPerson = personRepository.Get(idPerson)

    repoPerson.MarkAsVoted(true)

    personRepository.Update(repoPerson)

  }
}
