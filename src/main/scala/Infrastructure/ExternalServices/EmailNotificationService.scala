package com.redgroup.votox
package Infrastructure.ExternalServices

import Domain.Services.NotificationService

/**
 * Servicio de infrastructura que implementa nuestro treat de NotificationService y sobreescribe el metodo Notify, aqui simulamos que enviamos emails y podremos verlo en la consola.
 */
class EmailNotificationService extends NotificationService {

  override def Notify(email: String, body: String): Unit = {

    println(s"Sending Email to ${email} with body ${body}")

  }
}
