package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessInternalBehaviorElement
import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}
import ru.kvb74.semod.opengroup.archimate.meta.relationship.Junction
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait ApplicationInternalBehaviorElement
	extends Element

case object ApplicationInternalBehaviorElement
	extends ElementName

trait ApplicationInternalBehaviorElementRelationships[T <: ApplicationInternalBehaviorElement]
	extends ElementRelationships[T] {

	def aggregates(dst: ApplicationInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: ApplicationInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def realizes(dst: ApplicationServiceElement): T = tt._rel.realizes(dst)

	def accesses(dst: DataObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: ApplicationEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def realizes(dst: BusinessInternalBehaviorElement): T = tt._rel.realizes(dst)

	_register(ApplicationInternalBehaviorElement,
		JR.aggregates(ApplicationInternalBehaviorElement),
		JR.composedOf(ApplicationInternalBehaviorElement),
		JR.realizes(ApplicationServiceElement),
		JR.accesses(DataObjectElement),
		JR.triggers(ApplicationInternalBehaviorElement),
		JR.flowsTo(ApplicationInternalBehaviorElement),
		JR.triggers(ApplicationEventElement),
		JR.flowsTo(ApplicationEventElement),
		JR.realizes(BusinessInternalBehaviorElement)
	)
}
