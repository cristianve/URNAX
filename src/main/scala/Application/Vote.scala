package com.redgroup.votox
package Application

import Domain.Person
import Domain.Services.ValidationService

class Vote (val validationService: ValidationService) {


  def Execute( person:Person) : Boolean ={

    var validate = validationService.

  }

}
