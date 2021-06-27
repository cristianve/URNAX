package com.redgroup.votox
package Application

import Domain.Person
import Domain.Services.{ValidationService, VoteService}

import com.redgroup.votox.Application.Dto.VoteDto

class VoteApplicationService (val validationService: ValidationService, val voteService: VoteService) {

  def Execute(voteDto: VoteDto) : Unit ={

    validationService.validate(voteDto.idPerson)

    voteService.Vote(voteDto.idPerson,voteDto.idPoliticalParty)
  }

}
