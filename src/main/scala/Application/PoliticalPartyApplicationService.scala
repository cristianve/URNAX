package com.redgroup.votox
package Application

import Domain.PoliticalParty
import Domain.Repositories.PoliticalPartyRepository

/**
 * case class nos viene genial para el uso que le vamos a dar ya que por defecto los parametros son inmutables, ademas que nos aportan una sintaxis de inicialización compacta
 * Utilizamos injección de dependencias cumpliendo el patron DI asi bien solo conocemos los contratos de estas garantizando el bajo acoplamiento y alta cohesion, además cumpliendo el principio IoC mediante los treats aún profundizando mas podriamos decir que utilizamos el principio de sustitucion Liskov
 *@param politicalPartyRepository repositorio de partidos politicos injectado con una implementacion custom para trabajar con JSON
 */
case class PoliticalPartyApplicationService(politicalPartyRepository: PoliticalPartyRepository) {

  /**
   * @return una lista de partidos politicos. Utilizamos una lista inmutable ya que no pretendemos variarla
   */
  def Execute(): List[PoliticalParty] = {

    politicalPartyRepository.GetAll()

  }

}
