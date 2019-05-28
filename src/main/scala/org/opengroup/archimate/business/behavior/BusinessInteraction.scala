package org.opengroup.archimate.business.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessInternalBehaviorElement, BusinessInternalBehaviorElementRelationships}

case class BusinessInteraction(
	name: String,
	desc: String = ""
) extends Business
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalBehaviorElement {
	val id: String = IdGenerator.business.businessInteraction

	object rel extends BusinessInternalBehaviorElementRelationships[BusinessInteraction] {
		private[archimate] implicit val tt: BusinessInteraction = BusinessInteraction.this
	}

}
