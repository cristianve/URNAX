package com.redgroup.votox
package Domain.Services

import Domain.Person

import com.redgroup.votox.Domain.Exceptions.{UserAlreadyVotedException, UserNotExistException}
import com.redgroup.votox.Domain.Services.Repositories.PersonRepository

class ValidationService(personRepository: PersonRepository) {

  def validate(idPerson:Int): Unit ={

    val repoPerson = personRepository.Get(idPerson)

    if(repoPerson==null) throw UserNotExistException(s"The person with name: ${repoPerson.name} and NIF: ${repoPerson.nif} does not exists")

    if(repoPerson.hasVoted) throw UserAlreadyVotedException( s"The person with name: ${repoPerson.name} and NIF: ${repoPerson.nif} has already voted")

  }
}
