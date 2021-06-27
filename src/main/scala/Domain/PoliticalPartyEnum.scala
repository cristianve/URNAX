package com.redgroup.votox
package Domain


object PoliticalPartyEnum extends Enumeration {
  type PoliticalPartyEnum = Value
  val green: Domain.PoliticalPartyEnum.Value = Value("PACMA PARTY")
  val blue: Domain.PoliticalPartyEnum.Value = Value("PP PARTY")
  val red: Domain.PoliticalPartyEnum.Value = Value("PSOE PARTY")
}
