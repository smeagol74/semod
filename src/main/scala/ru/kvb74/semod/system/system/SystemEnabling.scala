package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemEnablingElement, SystemEnablingElementProps, SystemEnablingElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class SystemEnabling(
	name: String
) extends SystemLayer
	with SystemEnablingElement {

	case class SystemEnablingRelationships(
		override private[semod] implicit val tt: SystemEnabling = SystemEnabling.this
	) extends SystemEnablingElementRelationships[SystemEnabling]

	val rel: SystemEnablingRelationships = SystemEnablingRelationships()

	case class SystemEnablingProps(
		override private[semod] implicit val tt: SystemEnabling = SystemEnabling.this
	) extends SystemEnablingElementProps[SystemEnabling]

	val prop: SystemEnablingProps = SystemEnablingProps()

	_registerPrefix("SEn")
}
