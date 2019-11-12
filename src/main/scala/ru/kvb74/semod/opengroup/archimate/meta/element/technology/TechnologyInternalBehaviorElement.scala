package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.application.ApplicationInternalBehaviorElement
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessInternalBehaviorElement
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementRelationships}

trait TechnologyInternalBehaviorElement
	extends ArchimateElement

case object TechnologyInternalBehaviorElement
	extends ElementName

trait TechnologyInternalBehaviorElementRelationships[T <: TechnologyInternalBehaviorElement]
	extends ArchimateElementRelationships[T] {

	def realizes(dst: TechnologyServiceElement): T = tt._rel.realizes(dst)

	def aggregates(dst: TechnologyInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: TechnologyInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def accesses(dst: TechnologyObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def realizes(dst: BusinessInternalBehaviorElement): T = tt._rel.realizes(dst)

	def realizes(dst: ApplicationInternalBehaviorElement): T = tt._rel.realizes(dst)

	_register(TechnologyInternalBehaviorElement,
		RR.realizes(TechnologyServiceElement),
		RR.aggregates(TechnologyInternalBehaviorElement),
		RR.composedOf(TechnologyInternalBehaviorElement),
		RR.accesses(TechnologyObjectElement),
		RR.triggers(TechnologyInternalBehaviorElement),
		RR.flowsTo(TechnologyInternalBehaviorElement),
		RR.triggers(TechnologyEventElement),
		RR.flowsTo(TechnologyEventElement),
		RR.realizes(BusinessInternalBehaviorElement),
		RR.realizes(ApplicationInternalBehaviorElement),
	)
}
