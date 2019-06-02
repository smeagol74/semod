package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyInternalBehaviorElement, TechnologyInternalBehaviorElementRelationships}

case class TechnologyFunction(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyInternalBehaviorElement {
	val id: String = IdGenerator.technology.technologyFunction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyFunction]
		with TechnologyInternalBehaviorElementRelationships[TechnologyFunction] {
		private[archimate] implicit val tt: TechnologyFunction = TechnologyFunction.this
	}

}
