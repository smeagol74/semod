package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementProps, ArchimateElementRelationships}

trait BusinessInternalBehaviorElement
	extends ArchimateElement

case object BusinessInternalBehaviorElement
	extends ElementName

trait BusinessInternalBehaviorElementProps[T <: BusinessInternalBehaviorElement]
	extends ArchimateElementProps[T]

trait BusinessInternalBehaviorElementRelationships[T <: BusinessInternalBehaviorElement]
	extends ArchimateElementRelationships[T] {

	def aggregates(dst: BusinessInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: BusinessInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: BusinessPassiveStructureElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def realizes(dst: BusinessServiceElement): T = tt._rel.realizes(dst)

	_register(BusinessInternalBehaviorElement,
		RR.aggregates(BusinessInternalBehaviorElement),
		RR.composedOf(BusinessInternalBehaviorElement),
		RR.triggers(BusinessEventElement),
		RR.flowsTo(BusinessEventElement),
		RR.triggers(BusinessInternalBehaviorElement),
		RR.flowsTo(BusinessInternalBehaviorElement),
		RR.accesses(BusinessPassiveStructureElement),
		RR.realizes(BusinessServiceElement),
	)
}
