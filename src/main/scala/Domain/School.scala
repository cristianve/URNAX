package com.redgroup.votox
package Domain


/**
 * Case class ya que nos permite tener parametros inmutables y sintaxis de inicialización compacta (Minimal class).
 *
 * @param id identificador unico de colegio
 * @param direction direcion de donse se encuentra ubicado
 * @param name nombre del colegio
 */
case class School(id: Int, direction: Direction, name: String)
