package com.redgroup.votox
package Domain.Repositories

import Domain.Person

/**
 * Trait que nos permite definir la estructura de nuestro repositorio, así como el tipo de contrato especificando los valores esperados y funciones a implemntar.
 */
trait PersonRepository {

  def Get(id: Int): Person

  def GetAll(): List[Person]

  def Update(person: Person)

}
