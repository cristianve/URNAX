package com.redgroup.votox
package Domain.Exceptions

final case class NoSchoolForLocationFoundException(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)

