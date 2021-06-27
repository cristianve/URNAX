package com.redgroup.votox
package Domain.Services

import akka.actor.Actor

trait NotificationService {

  def Notify(email: String, body: String): Unit

}
