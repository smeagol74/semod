package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.relationship.Junction

trait BusinessEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object BusinessEventElement
	extends ElementName

trait BusinessEventElementRelationships[T <: BusinessEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: BusinessServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessServiceElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: BusinessPassiveStructureElement): T = tt._rel.accesses(dst)

	_register(BusinessEventElement,
		JR.triggers(BusinessInternalBehaviorElement),
		JR.flowsTo(BusinessInternalBehaviorElement),
		JR.triggers(BusinessEventElement),
		JR.flowsTo(BusinessEventElement),
		JR.triggers(BusinessServiceElement),
		JR.flowsTo(BusinessServiceElement),
		JR.accesses(BusinessPassiveStructureElement),
	)

}
