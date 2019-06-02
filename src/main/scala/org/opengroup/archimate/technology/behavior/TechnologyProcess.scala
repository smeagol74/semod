package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyInternalBehaviorElement, TechnologyInternalBehaviorElementRelationships}

case class TechnologyProcess(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyInternalBehaviorElement {
	val id: String = IdGenerator.technology.technologyProcess

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyProcess]
		with TechnologyInternalBehaviorElementRelationships[TechnologyProcess] {
		private[archimate] implicit val tt: TechnologyProcess = TechnologyProcess.this
	}

}
