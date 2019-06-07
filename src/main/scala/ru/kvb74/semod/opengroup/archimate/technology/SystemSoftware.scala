package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{SystemSoftwareElement, SystemSoftwareElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class SystemSoftware(
	name: String,
	desc: String = ""
) extends Technology
	with SystemSoftwareElement {

	case class SystemSoftwareRelationships(
		override private[archimate] implicit val tt: SystemSoftware = SystemSoftware.this
	) extends SystemSoftwareElementRelationships[SystemSoftware]

	val rel: SystemSoftwareRelationships = SystemSoftwareRelationships()

}
