package org.opengroup.archimate.business.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalBehaviorElement, BusinessInternalBehaviorElementRelationships}

case class BusinessProcess(
	name: String,
	desc: String = ""
) extends Business
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalBehaviorElement {
	val id: String = IdGenerator.business.businessProcess

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessProcess]
		with BusinessInternalBehaviorElementRelationships[BusinessProcess] {
		override private[archimate] implicit val tt: BusinessProcess = BusinessProcess.this
	}

}
