package com.redgroup.votox
package Domain.Services

/**
 * Trait, interfaz que permite tener una implementacion por defecto en escala, todos los servicios de dominio que requieren una implementacion especifica estan declarados como trait para aislar la capa de dominio de infrastructura y hace posible que podeamos beneficiarnos de algunos principios solid explicados en otros ficheros de esta app
 * Para nosotros no es mas que un contrato
 **/
trait NotificationService {

  def Notify(email: String, body: String): Unit

}
