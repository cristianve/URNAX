package com.redgroup.votox
package Domain.Exceptions

/**
 * Es una clase final ya que no nos interesa que nadie pueda heredar de ella
 * De nuevo una case class para beneficiarnos de las ventajas de rapidas que nos aporta
 * @param message declarado como privado dado la casuistica de la case class y la prohibicion de modificar este parametro desde fuera de la clase
 * Explicado el caso anterior, aquí mencionariamos que aplicamos unos valores por defecto ya que scala lo permite para no tener que pasar ningun parametro si no lo necesitamos
 */
final case class UserAlreadyVotedException(private val message: String = "") extends Exception(message)
