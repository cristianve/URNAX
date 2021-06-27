package com.redgroup.votox
package Domain

case class Person(id: Int, name: String, surname: String, nif: String, email: String, direction: Direction, var hasVoted: Boolean) {

  def MarkAsVoted(voted: Boolean): Unit = {
    hasVoted = voted;
  }

}
