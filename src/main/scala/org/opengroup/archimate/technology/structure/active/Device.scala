package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyNodeElement, TechnologyNodeElementRelationships}

case class Device(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyNodeElement {
	val id: String = IdGenerator.technology.device

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Device]
		with TechnologyNodeElementRelationships[Device] {
		private[archimate] implicit val tt: Device = Device.this

		def assignedTo(dst: SystemSoftware): Device = tt._rel.assignedTo(dst)

		def associatedWith(dst: CommunicationNetwork): Device = tt._rel.associatedWith(dst)
	}

}
