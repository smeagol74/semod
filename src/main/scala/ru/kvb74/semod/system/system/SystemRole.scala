package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.SystemRoleElement
import ru.kvb74.semod.system.meta.layer.SystemLayer
import ru.kvb74.semod.system.meta.element.SystemRoleElementRelationships

case class SystemRole(
                       name: String,
                       desc: String = ""
                     ) extends SystemLayer
  with SystemRoleElement {

  case class SystemRoleRelationships(
                                      override private[semod] implicit val tt: SystemRole = SystemRole.this
                                    ) extends SystemRoleElementRelationships[SystemRole]

  val rel: SystemRoleRelationships = SystemRoleRelationships()

  _registerPrefix("SRole")
}
