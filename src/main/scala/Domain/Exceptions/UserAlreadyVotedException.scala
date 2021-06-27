package com.redgroup.votox
package Domain.Exceptions

final case class UserAlreadyVotedException(private val message: String = "") extends Exception(message)
