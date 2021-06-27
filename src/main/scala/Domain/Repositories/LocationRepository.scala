package com.redgroup.votox
package Domain.Repositories

import Domain.School

/**
 * Trait que nos permite definir la estructura de nuestro repositorio, así como el tipo de contrato especificando los valores esperados y funciones a implemntar.
 */
trait LocationRepository {

  def Get(postalCode: String): School

}
