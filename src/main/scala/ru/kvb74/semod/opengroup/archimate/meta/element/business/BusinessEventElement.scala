package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object BusinessEventElement
	extends ElementName

trait BusinessEventElementProps[T <: BusinessEventElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

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
		RR.triggers(BusinessInternalBehaviorElement),
		RR.flowsTo(BusinessInternalBehaviorElement),
		RR.triggers(BusinessEventElement),
		RR.flowsTo(BusinessEventElement),
		RR.triggers(BusinessServiceElement),
		RR.flowsTo(BusinessServiceElement),
		RR.accesses(BusinessPassiveStructureElement),
	)

}
