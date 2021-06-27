package com.redgroup.votox
package Domain.Services.Repositories

import Domain.Person

trait PersonRepository {

  def Get(id: Int): Person

  def Update(person: Person)

}
