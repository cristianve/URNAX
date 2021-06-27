package com.redgroup.votox
package Domain.Services

import Domain.{Person, School}

import com.redgroup.votox.Domain.Exceptions.NoSchoolForLocationFoundException
import com.redgroup.votox.Domain.Services.Repositories.LocationRepository

class VoteLocationService(locationRepository: LocationRepository) {

  def GetLocationForPerson( person:Person): School = {

    val repoLocation = locationRepository.Get(person.direction.postalCode)

    if(repoLocation == null) throw NoSchoolForLocationFoundException(s"Unable to found a school for the person: ${person.name} and with postal code: ${person.direction.postalCode}")

    repoLocation
  }

  object VoteLocationService{
    def apply = new VoteLocationService(locationRepository: LocationRepository)
  }
}
