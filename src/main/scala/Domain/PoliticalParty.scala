package com.redgroup.votox
package Domain

case class PoliticalParty(id: Int, name: String, var count: Int) {

  def UpdateVotes(): Unit = {
    count += 1
  }
}
