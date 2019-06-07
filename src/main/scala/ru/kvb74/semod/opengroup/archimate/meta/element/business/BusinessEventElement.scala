package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.relationship.Junction
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait BusinessEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object BusinessEventElement
	extends ElementName

trait BusinessEventElementRelationships[T <: BusinessEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: BusinessServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessServiceElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: BusinessPassiveStructureElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

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
