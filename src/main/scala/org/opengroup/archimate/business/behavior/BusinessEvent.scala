package org.opengroup.archimate.business.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, ElementRelationships, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalBehaviorElement, BusinessPassiveStructureElement}

case class BusinessEvent(
	name: String,
	desc: String = ""
) extends Business
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.business.businessEvent

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessEvent] {
		override private[archimate] implicit val tt: BusinessEvent = BusinessEvent.this

		def triggers(dst: BusinessInternalBehaviorElement): BusinessEvent = tt._rel.triggers(dst)

		def flowsTo(dst: BusinessInternalBehaviorElement): BusinessEvent = tt._rel.flowsTo(dst)

		def triggers(dst: BusinessEvent): BusinessEvent = tt._rel.triggers(dst)

		def flowsTo(dst: BusinessEvent): BusinessEvent = tt._rel.flowsTo(dst)

		def triggers(dst: BusinessService): BusinessEvent = tt._rel.triggers(dst)

		def flowsTo(dst: BusinessService): BusinessEvent = tt._rel.flowsTo(dst)

		def accesses(dst: BusinessPassiveStructureElement): BusinessEvent = tt._rel.accesses(dst)
	}

}