package ru.kvb74.semod.opengroup.archimate.meta.element.composite

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait GroupingElement
	extends Element

case object GroupingElement
	extends ElementName

trait GroupingElementRelationships[T <: GroupingElement]
	extends ElementRelationships[T] {

	def aggregates(dst: Element): T = tt._rel.aggregates(dst)

	def composedOf(dst: Element): T = tt._rel.composedOf(dst)

	def assignedTo(dst: Element): T = tt._rel.assignedTo(dst)

	def realizes(dst: Element): T = tt._rel.realizes(dst)

	def serves(dst: Element): T = tt._rel.serves(dst)

	def accesses(dst: Element, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def influences(dst: Element, label: String): T = tt._rel.influences(dst, label)

	def triggers(dst: Element): T = tt._rel.triggers(dst)

	def flowsTo(dst: Element, label: String): T = tt._rel.flowsTo(dst, label)

	def specializationOf(dst: Element): T = tt._rel.specializationOf(dst)

	_register(GroupingElement,
		JR.aggregates(Element),
		JR.composedOf(Element),
		JR.assignedTo(Element),
		JR.realizes(Element),
		JR.serves(Element),
		JR.accesses(Element),
		JR.influences(Element),
		JR.triggers(Element),
		JR.flowsTo(Element),
		JR.specializationOf(Element)
	)

}
