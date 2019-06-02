package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyNodeElement}
import org.opengroup.archimate.technology.behavior.TechnologyService

case class TechnologyInterface(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyInterface

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyInterface] {
		private[archimate] implicit val tt: TechnologyInterface = TechnologyInterface.this

		def assignedTo(dst: TechnologyService): TechnologyInterface = tt._rel.assignedTo(dst)
		def serves(dst: TechnologyNodeElement): TechnologyInterface = tt._rel.serves(dst)
		def serves(dst: SystemSoftware): TechnologyInterface = tt._rel.serves(dst)
		def serves(dst: Device): TechnologyInterface = tt._rel.serves(dst)
		def serves(dst: TechnologyCollaboration): TechnologyInterface = tt._rel.serves(dst)
	}

}
