package com.redgroup.votox
package Domain.Services

import akka.actor.Actor

trait NotificationService extends Actor {

  def Notify(email: String, body: String): Unit

}
