package com.redgroup.votox
package Domain.Services

import Domain.Exceptions.NoSchoolForLocationFoundException
import Domain.Repositories.LocationRepository
import Domain.{Person, School}

class VoteLocationService(locationRepository: LocationRepository) {

  def GetLocationForPerson(person: Person): School = {

    val repoLocation = locationRepository.Get(person.direction.postalCode)

    if (repoLocation == null) throw NoSchoolForLocationFoundException(s"Unable to found a school for the person: ${person.name} and with postal code: ${person.direction.postalCode}")

    repoLocation
  }

  object VoteLocationService {
    def apply = new VoteLocationService(locationRepository: LocationRepository)
  }
}
