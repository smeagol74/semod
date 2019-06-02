package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class TechnologyProcess(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyProcess

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyProcess] {
		private[archimate] implicit val tt: TechnologyProcess = TechnologyProcess.this
	}

}
