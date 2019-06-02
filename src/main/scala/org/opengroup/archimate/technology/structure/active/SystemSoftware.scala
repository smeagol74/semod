package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class SystemSoftware(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.systemSoftware

	object rel extends StrategyCoreStructureBehaviorElementRelationships[SystemSoftware] {
		private[archimate] implicit val tt: SystemSoftware = SystemSoftware.this
	}

}
