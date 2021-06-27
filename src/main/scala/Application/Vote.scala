package com.redgroup.votox
package Application

import Domain.Person
import Domain.Services.{ValidationService, VoteService}

class Vote (val validationService: ValidationService, val voteService: VoteService) {


  def Execute( person:Person) : Unit ={

    validationService.validate(person)

    voteService.Vote(person)
  }

}
