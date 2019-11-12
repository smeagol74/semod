package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessInternalBehaviorElement
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementRelationships}

trait ApplicationInternalBehaviorElement
	extends ArchimateElement

case object ApplicationInternalBehaviorElement
	extends ElementName

trait ApplicationInternalBehaviorElementRelationships[T <: ApplicationInternalBehaviorElement]
	extends ArchimateElementRelationships[T] {

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
		RR.aggregates(ApplicationInternalBehaviorElement),
		RR.composedOf(ApplicationInternalBehaviorElement),
		RR.realizes(ApplicationServiceElement),
		RR.accesses(DataObjectElement),
		RR.triggers(ApplicationInternalBehaviorElement),
		RR.flowsTo(ApplicationInternalBehaviorElement),
		RR.triggers(ApplicationEventElement),
		RR.flowsTo(ApplicationEventElement),
		RR.realizes(BusinessInternalBehaviorElement)
	)
}
