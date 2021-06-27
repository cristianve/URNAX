package com.redgroup.votox
package Domain

/**
 * Case class ya que nos permite tener parametros inmutables y sintaxis de inicialización compacta.
 *
 * @param city nombre de la ciudad
 * @param state nombre de la provincia
 * @param postalCode codigo postal
 */
case class Direction(city: String, state: String, postalCode: String)

