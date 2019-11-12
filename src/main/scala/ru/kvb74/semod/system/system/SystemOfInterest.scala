package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemOfInterestElement, SystemOfInterestElementRelationships}
import ru.kvb74.semod.system.meta.layer.System

case class SystemOfInterest(
                             name: String,
                             desc: String = ""
                           ) extends System
  with SystemOfInterestElement {

  case class SystemOfInterestRelationships(
                                            override private[semod] implicit val tt: SystemOfInterest = SystemOfInterest.this
                                          ) extends SystemOfInterestElementRelationships[SystemOfInterest]

  val rel: SystemOfInterestRelationships = SystemOfInterestRelationships()

  _registerPrefix("SOI")
}
