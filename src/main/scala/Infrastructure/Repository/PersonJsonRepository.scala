package com.redgroup.votox
package Infrastructure.Repository

import com.redgroup.votox.Domain.Person
import com.redgroup.votox.Domain.Services.Repositories.PersonRepository

class PersonJsonRepository extends PersonRepository {
  override def Get(id: Int): Person = ???

  override def Update(person: Person): Unit = ???

}
