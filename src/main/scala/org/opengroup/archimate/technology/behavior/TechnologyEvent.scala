package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class TechnologyEvent(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyEvent

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyEvent] {
		private[archimate] implicit val tt: TechnologyEvent = TechnologyEvent.this
	}

}
