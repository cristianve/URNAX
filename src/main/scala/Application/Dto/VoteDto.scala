package com.redgroup.votox
package Application.Dto

/**
 * case class VoteDto, nos viene genial para el uso que le vamos a dar ya que por defecto los parametros son inmutables, ademas que nos aportan una sintaxis de inicialización compacta
 *
 * @param idPerson id de la persona
 * @param idPoliticalParty id del partido politico
 */
case class VoteDto(idPerson: Int, idPoliticalParty: Int)

