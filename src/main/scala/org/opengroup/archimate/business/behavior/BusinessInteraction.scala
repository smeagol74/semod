package org.opengroup.archimate.business.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalBehaviorElement, BusinessInternalBehaviorElementRelationships}

case class BusinessInteraction(
	name: String,
	desc: String = ""
) extends Business
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalBehaviorElement {
	val id: String = IdGenerator.business.businessInteraction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessInteraction]
		with BusinessInternalBehaviorElementRelationships[BusinessInteraction] {
		override private[archimate] implicit val tt: BusinessInteraction = BusinessInteraction.this
	}

}
