package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{SystemSoftwareElement, SystemSoftwareElementProps, SystemSoftwareElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class SystemSoftware(
	name: String
) extends TechnologyLayer
	with SystemSoftwareElement {

	case class SystemSoftwareRelationships(
		override private[semod] implicit val tt: SystemSoftware = SystemSoftware.this
	) extends SystemSoftwareElementRelationships[SystemSoftware]

	val rel: SystemSoftwareRelationships = SystemSoftwareRelationships()

	case class SystemSoftwareProps(
		override private[semod] implicit val tt: SystemSoftware = SystemSoftware.this
	) extends SystemSoftwareElementProps[SystemSoftware]

	val prop: SystemSoftwareProps = SystemSoftwareProps()

	_registerPrefix("TSS")
}
