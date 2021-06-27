package com.redgroup.votox
package Domain.Services.Repositories

import Domain.School

trait LocationRepository {

  def Get(postalCode: String): School

}
