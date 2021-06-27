package com.redgroup.votox
package Application

import Application.Dto.VoteDto
import Domain.Services.{ValidationService, VoteService}

/**
 * case class nos viene genial para el uso que le vamos a dar ya que por defecto los parametros son inmutables, ademas que nos aportan una sintaxis de inicialización compacta
 * Utilizamos injección de dependencias cumpliendo el patron DI asi bien solo conocemos los contratos de estas garantizando el bajo acoplamiento y alta cohesion, además cumpliendo el principio IoC mediante los treats aún profundizando mas podriamos decir que utilizamos el principio de sustitucion Liskov
 * Nos valemos de el type Unit de Scala para no devolver ningun objeto en concreto sino el tipo especial minimo del cual no hereda ningun otro objeto
 * @param voteService servicio de votacion encargado de votar
 * @param validationService servicio de validacion encargado de validar si un usuario a votado y obviamente de que exista
 */

case class VoteApplicationService(val validationService: ValidationService, val voteService: VoteService) {

  def Execute(voteDto: VoteDto): Unit = {

    validationService.validate(voteDto.idPerson)

    voteService.Vote(voteDto.idPerson, voteDto.idPoliticalParty)
  }

}
