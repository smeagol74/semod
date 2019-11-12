package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemOurElement, SystemOurElementRelationships}
import ru.kvb74.semod.system.meta.layer.System

case class SystemOur(
                      name: String,
                      desc: String = ""
                    ) extends System
  with SystemOurElement {

  case class SystemOurRelationships(
                                     override private[semod] implicit val tt: SystemOur = SystemOur.this
                                   ) extends SystemOurElementRelationships[SystemOur]

  val rel: SystemOurRelationships = SystemOurRelationships()

  _registerPrefix("SOur")
}
