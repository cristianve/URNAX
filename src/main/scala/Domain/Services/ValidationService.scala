package com.redgroup.votox
package Domain.Services

import Domain.Exceptions.{UserAlreadyVotedException, UserNotExistException}
import Domain.Repositories.PersonRepository

/**
 * Servicio de cominio encargado de aplicar logica de negocio
 * case class nos viene genial para el uso que le vamos a dar ya que por defecto los parametros son inmutables, ademas que nos aportan una sintaxis de inicialización compacta
 * En esta clase utilizamos la herencia mediante las excepciones custom que hemos creado para poder diferenciar en el case del try catch en nuestro cliente Http y asi poder devolver el codigo de error adecuado
 * Utilizamos injección de dependencias cumpliendo el patron DI asi bien solo conocemos los contratos de estas garantizando el bajo acoplamiento y alta cohesion, además cumpliendo el principio IoC mediante los treats aún profundizando mas podriamos decir que utilizamos el principio de sustitucion Liskov
 * Nos valemos de el type Unit de Scala para no devolver ningun objeto en concreto sino el tipo especial minimo del cual no hereda ningun otro objeto
 * No estaria mal comentar que podriamos haberlas convertido mediante un companion object en singleton (aunque ha sido mas una cuestion de tiempo que de ganas)
 * @param personRepository repositorio de personas injectado con una implementacion custom para trabajar con JSON
 **/
case class ValidationService(personRepository: PersonRepository) {

  def validate(idPerson: Int): Unit = {

    val repoPerson = personRepository.Get(idPerson)

    if (repoPerson == null) throw UserNotExistException(s"The person with id: ${idPerson} does not exists")

    if (repoPerson.hasVoted) throw UserAlreadyVotedException(s"The person with name: ${repoPerson.name} and NIF: ${repoPerson.nif} has already voted")

  }
}
