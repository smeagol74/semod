package ru.kvb74.semod.opengroup.archimate.meta.element.composite

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementProps, ArchimateElementRelationships}

trait GroupingElement
	extends ArchimateElement

case object GroupingElement
	extends ElementName

trait GroupingElementProps[T <: GroupingElement]
	extends ArchimateElementProps[T]

trait GroupingElementRelationships[T <: GroupingElement]
	extends ArchimateElementRelationships[T] {

	def aggregates(dst: ArchimateElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: ArchimateElement): T = tt._rel.composedOf(dst)

	def assignedTo(dst: ArchimateElement): T = tt._rel.assignedTo(dst)

	def realizes(dst: ArchimateElement): T = tt._rel.realizes(dst)

	def serves(dst: ArchimateElement): T = tt._rel.serves(dst)

	def accesses(dst: ArchimateElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def influences(dst: ArchimateElement, label: String): T = tt._rel.influences(dst, label)

	def triggers(dst: ArchimateElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ArchimateElement, label: String): T = tt._rel.flowsTo(dst, label)

	def specializationOf(dst: ArchimateElement): T = tt._rel.specializationOf(dst)

	_register(GroupingElement,
		RR.aggregates(ArchimateElement),
		RR.composedOf(ArchimateElement),
		RR.assignedTo(ArchimateElement),
		RR.realizes(ArchimateElement),
		RR.serves(ArchimateElement),
		RR.accesses(ArchimateElement),
		RR.influences(ArchimateElement),
		RR.triggers(ArchimateElement),
		RR.flowsTo(ArchimateElement),
		RR.specializationOf(ArchimateElement)
	)

}
