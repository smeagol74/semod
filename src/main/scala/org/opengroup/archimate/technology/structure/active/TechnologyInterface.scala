package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class TechnologyInterface(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyInterface

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyInterface] {
		private[archimate] implicit val tt: TechnologyInterface = TechnologyInterface.this
	}

}
