package com.redgroup.votox
package Domain

/**
 * Case class ya que nos permite tener parametros inmutables y sintaxis de inicialización compacta (Minimal class).
 * En este caso hasVoted es mutable.
 *
 * @param id
 * @param name nombre del ciudadano
 * @param surname apellido ciudadadno
 * @param nif numero de identificacion fiscal
 * @param email correo electronico de contacto
 * @param direction direcion del ciudadano
 * @param hasVoted variable para saber si ha votado previamente
 */
case class Person(id: Int, name: String, surname: String, nif: String, email: String, direction: Direction, var hasVoted: Boolean) {

  /**
   * Funcion que nos permite cambiar el estado de la votación de la persona
   * @param voted booleano has voted
   */
  def MarkAsVoted(voted: Boolean): Unit = {
    hasVoted = voted;
  }

}
