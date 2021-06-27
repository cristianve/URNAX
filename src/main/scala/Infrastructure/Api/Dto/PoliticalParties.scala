package com.redgroup.votox
package Infrastructure.Api.Dto

import Domain.PoliticalParty

/**
 * De nuevo case class nos viene genial para nuestros Dto's
 * @param items una liste de partidos politicos para poder pasarlo a JSON
 */
final case class PoliticalParties(items: List[PoliticalParty])

