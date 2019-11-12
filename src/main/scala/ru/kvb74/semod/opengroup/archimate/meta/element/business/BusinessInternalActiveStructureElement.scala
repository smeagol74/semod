package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementRelationships}

trait BusinessInternalActiveStructureElement
	extends ArchimateElement

case object BusinessInternalActiveStructureElement
	extends ElementName

trait BusinessInternalActiveStructureElementRelationships[T <: BusinessInternalActiveStructureElement]
	extends ArchimateElementRelationships[T] {

	def composedOf(dst: BusinessInterfaceElement): T = tt._rel.composedOf(dst)

	def assignedTo(dst: BusinessEventElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: BusinessInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	_register(BusinessInternalActiveStructureElement,
		RR.composedOf(BusinessInterfaceElement),
		RR.assignedTo(BusinessEventElement),
		RR.assignedTo(BusinessInternalBehaviorElement)
	)
}