package com.redgroup.votox
package Infrastructure.ExternalServices

import Domain.Services.NotificationService

class EmailNotificationService extends NotificationService {

  override def Notify(email: String, body: String): Unit = {

    println(s"Sending Email to ${email} with body ${body}")

  }
}
