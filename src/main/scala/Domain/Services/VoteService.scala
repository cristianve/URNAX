package com.redgroup.votox
package Domain.Services

import Domain.Services.Repositories.PersonRepository

import com.redgroup.votox.Domain.Person

class VoteService (personRepository: PersonRepository){

  def Vote(person:Person): Unit ={

    val repoPerson = personRepository.Get(person.id)

    repoPerson.hasVoted = true

    personRepository.Update(repoPerson)

  }
}
