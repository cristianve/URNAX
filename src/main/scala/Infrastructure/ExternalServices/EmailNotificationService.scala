package com.redgroup.votox
package Infrastructure.ExternalServices

import Domain.Services.NotificationService

import play.api.libs.mailer._

class EmailNotificationService extends NotificationService {

  override def Notify(email: String, body: String): Unit = {

    val message = Email(
      s"Notificacion de voto",
      "carlos.mlpz@gmail.com",
      Seq(s"TO <${email}>"),
      bodyText = Some("A text message"),
    )

    println(s"Sending Email ${message.toString()}")

  }

  override def receive: Receive = null
}
