package com.redgroup.votox
package Domain

/**
 * Case class ya que nos permite tener parametros inmutables y sintaxis de inicialización compacta (Minimal class).
 * En este caso count es mutable.
 *
 * @param id identificador de partido
 * @param name nombre del partido policito
 * @param count suma total de votos del partido
 *
 */
case class PoliticalParty(id: Int, name: String, var count: Int) {

  /**
   * Funcion que nos permite incrementar el contador de votos por cada partido
   */
  def UpdateVotes(): Unit = {
    count += 1
  }
}
