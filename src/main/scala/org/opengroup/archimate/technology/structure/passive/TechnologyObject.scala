package org.opengroup.archimate.technology.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class TechnologyObject(
	name: String,
	desc: String = ""
) extends Technology
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyObject

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyObject] {
		private[archimate] implicit val tt: TechnologyObject = TechnologyObject.this
	}

}
