package com.redgroup.votox
package Application

import Application.Dto.VoteDto
import Domain.Services.{ValidationService, VoteService}

class VoteApplicationService(val validationService: ValidationService, val voteService: VoteService) {

  def Execute(voteDto: VoteDto): Unit = {

    validationService.validate(voteDto.idPerson)

    voteService.Vote(voteDto.idPerson, voteDto.idPoliticalParty)
  }

}
