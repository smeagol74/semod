package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyNodeElement, TechnologyNodeElementRelationships}

case class SystemSoftware(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyNodeElement {
	val id: String = IdGenerator.technology.systemSoftware

	object rel extends StrategyCoreStructureBehaviorElementRelationships[SystemSoftware]
		with TechnologyNodeElementRelationships[SystemSoftware] {
		private[archimate] implicit val tt: SystemSoftware = SystemSoftware.this

		def isSpecializationOf(dst: TechnologyNodeElement): SystemSoftware = tt._rel.isSpecializationOf(dst)
		def assignedTo(dst: SystemSoftware): SystemSoftware = tt._rel.assignedTo(dst)

		def associatedWith(dst: CommunicationNetwork): SystemSoftware = tt._rel.associatedWith(dst)
	}

}
