package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{SystemSoftwareElement, SystemSoftwareElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class SystemSoftware(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with SystemSoftwareElement {

	case class SystemSoftwareRelationships(
		override private[semod] implicit val tt: SystemSoftware = SystemSoftware.this
	) extends SystemSoftwareElementRelationships[SystemSoftware]

	val rel: SystemSoftwareRelationships = SystemSoftwareRelationships()

	_registerPrefix("TSS")
}
