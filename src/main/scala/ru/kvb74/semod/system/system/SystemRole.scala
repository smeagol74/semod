package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemRoleElement, SystemRoleElementProps, SystemRoleElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class SystemRole(
	name: String
) extends SystemLayer
	with SystemRoleElement {

	case class SystemRoleRelationships(
		override private[semod] implicit val tt: SystemRole = SystemRole.this
	) extends SystemRoleElementRelationships[SystemRole]

	val rel: SystemRoleRelationships = SystemRoleRelationships()

	case class SystemRoleProps(
		override private[semod] implicit val tt: SystemRole = SystemRole.this
	) extends SystemRoleElementProps[SystemRole]

	val prop: SystemRoleProps = SystemRoleProps()

	_registerPrefix("SRole")
}
