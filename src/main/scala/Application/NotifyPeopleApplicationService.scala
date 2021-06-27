package com.redgroup.votox
package Application

import Domain.Repositories.{LocationRepository, PersonRepository}
import Domain.Services.NotificationService

class NotifyPeopleApplicationService(personRepository: PersonRepository, locationRepository: LocationRepository, notificationService: NotificationService) {


  def Execute(): Unit = {

    personRepository.GetAll().foreach(p => {
      notificationService.Notify(p.email, s" Tu colegio electoral es: ${locationRepository.Get(p.direction.postalCode).name} en: ${locationRepository.Get(p.direction.postalCode).direction.city}")
    })

  }

}
