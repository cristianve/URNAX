package com.redgroup.votox
package Domain.Repositories

import Domain.School

trait LocationRepository {

  def Get(postalCode: String): School

}
