package com.redgroup.votox
package Domain.Repositories

import Domain.Person

trait PersonRepository {

  def Get(id: Int): Person

  def GetAll(): List[Person]

  def Update(person: Person)

}
