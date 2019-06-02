package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class TechnologyCollaboration(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyCollaboration

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyCollaboration] {
		private[archimate] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this
	}

}
