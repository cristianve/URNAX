package com.redgroup.votox
package Application

import Domain.Repositories.{LocationRepository, PersonRepository}
import Domain.Services.NotificationService

/**
 * case class nos viene genial para el uso que le vamos a dar ya que por defecto los parametros son inmutables, ademas que nos aportan una sintaxis de inicialización compacta
 * En esta clase utilizamos High Order Functions como se puede ver en el metodo .Notify()
 * Utilizamos injección de dependencias cumpliendo el patron DI asi bien solo conocemos los contratos de estas garantizando el bajo acoplamiento y alta cohesion, además cumpliendo el principio IoC mediante los treats aún profundizando mas podriamos decir que utilizamos el principio de sustitucion Liskov
 * Nos valemos de el type Unit de Scala para no devolver ningun objeto en concreto sino el tipo especial minimo del cual no hereda ningun otro objeto
 * @param personRepository repositorio de personas injectado con una implementacion custom para trabajar con JSON
 * @param locationRepository repositorio de escuelas injectado con una implementacion custom para trabajar con JSON
 * @param notificationService servicio encargado de notificar mediante un email y un mensaje ( implementacion fake que saldrá por consola )
 */
case class NotifyPeopleApplicationService(personRepository: PersonRepository, locationRepository: LocationRepository, notificationService: NotificationService) {

  def Execute(): Unit = {
    personRepository.GetAll().foreach(p => {
      notificationService.Notify(p.email, s" Tu colegio electoral es: ${locationRepository.Get(p.direction.postalCode).name} en: ${locationRepository.Get(p.direction.postalCode).direction.city}")
    })

  }

}
