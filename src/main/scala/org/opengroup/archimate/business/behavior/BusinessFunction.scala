package org.opengroup.archimate.business.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalBehaviorElement, BusinessInternalBehaviorElementRelationships}

case class BusinessFunction(
	name: String,
	desc: String = ""
) extends Business
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalBehaviorElement {
	val id: String = IdGenerator.business.businessFunction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessFunction]
		with BusinessInternalBehaviorElementRelationships[BusinessFunction] {
		override private[archimate] implicit val tt: BusinessFunction = BusinessFunction.this
	}

}
