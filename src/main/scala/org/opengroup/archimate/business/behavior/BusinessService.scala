package org.opengroup.archimate.business.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, ElementRelationships, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalBehaviorElement, BusinessPassiveStructureElement}

case class BusinessService(
	name: String,
	desc: String = ""
) extends Business
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {

	val id: String = IdGenerator.business.businessService

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessService] {

		override private[archimate] implicit val tt: BusinessService = BusinessService.this

		def triggers(dst: BusinessService): BusinessService = tt._rel.triggers(dst)

		def flowsTo(dst: BusinessService): BusinessService = tt._rel.flowsTo(dst)

		def accesses(dst: BusinessPassiveStructureElement): BusinessService = tt._rel.accesses(dst)

		def serves(dst: BusinessInternalBehaviorElement): BusinessService = tt._rel.serves(dst)

		def serves(dst: BusinessInternalActiveStructureElement): BusinessService = tt._rel.serves(dst)

		def triggers(dst: BusinessEvent): BusinessService = tt._rel.triggers(dst)

		def flowsTo(dst: BusinessEvent): BusinessService = tt._rel.flowsTo(dst)
	}

}
