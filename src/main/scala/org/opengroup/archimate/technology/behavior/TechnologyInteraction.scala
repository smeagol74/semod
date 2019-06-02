package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyInternalBehaviorElement, TechnologyInternalBehaviorElementRelationships}

case class TechnologyInteraction(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyInternalBehaviorElement {
	val id: String = IdGenerator.technology.technologyInteraction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyInteraction]
		with TechnologyInternalBehaviorElementRelationships[TechnologyInteraction] {
		private[archimate] implicit val tt: TechnologyInteraction = TechnologyInteraction.this
	}

}
