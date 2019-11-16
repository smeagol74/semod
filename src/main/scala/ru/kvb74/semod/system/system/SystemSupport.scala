package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemSupportElement, SystemSupportElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class SystemSupport(
                      name: String,
                      desc: String = ""
                    ) extends SystemLayer
  with SystemSupportElement {

  case class SystemSupportRelationships(
                                     override private[semod] implicit val tt: SystemSupport = SystemSupport.this
                                   ) extends SystemSupportElementRelationships[SystemSupport]

  val rel: SystemSupportRelationships = SystemSupportRelationships()

  _registerPrefix("SSup")
}
