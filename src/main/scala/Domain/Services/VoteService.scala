package com.redgroup.votox
package Domain.Services

import Domain.Repositories.{PersonRepository, PoliticalPartyRepository}

/**
 * Servicio de cominio encargado de aplicar logica de negocio
 * case class nos viene genial para el uso que le vamos a dar ya que por defecto los parametros son inmutables, ademas que nos aportan una sintaxis de inicialización compacta
 * En esta clase utilizamos la herencia mediante las excepciones custom que hemos creado para poder diferenciar en el case del try catch en nuestro cliente Http y asi poder devolver el codigo de error adecuado
 * Utilizamos injección de dependencias cumpliendo el patron DI asi bien solo conocemos los contratos de estas garantizando el bajo acoplamiento y alta cohesion, además cumpliendo el principio IoC mediante los treats aún profundizando mas podriamos decir que utilizamos el principio de sustitucion Liskov
 * Nos valemos de el type Unit de Scala para no devolver ningun objeto en concreto sino el tipo especial minimo del cual no hereda ningun otro objeto
 *
 * @param personRepository repositorio de personas injectado con una implementacion custom para trabajar con JSON
 * @param politicalPartyRepository repositorio de partidos politicos injectado con una implementacion custom para trabajar con JSON
 **/

class VoteService(personRepository: PersonRepository, politicalPartyRepository: PoliticalPartyRepository) {

  /**
   *  Funcion principal encargada de ejecutar todos los pasos necesarios para realizar una votación
   * @param idPerson identificador de persona votante
   * @param idPoliticalParty identificador de partido politico a votar
   */
  def Vote(idPerson: Int, idPoliticalParty: Int): Unit = {

    val repoPerson = personRepository.Get(idPerson)

    val repoPoliticalParty = politicalPartyRepository.Get(idPoliticalParty)

    repoPerson.MarkAsVoted(true)

    repoPoliticalParty.UpdateVotes()

    personRepository.Update(repoPerson)
    politicalPartyRepository.Update(repoPoliticalParty)
  }
}
