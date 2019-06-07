package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationInternalBehaviorElement}
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{NodeElement, TechnologyInternalBehaviorElement}
import ru.kvb74.semod.opengroup.archimate.meta.relationship.Junction
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait BusinessServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object BusinessServiceElement
	extends ElementName

trait BusinessServiceElementRelationships[T <: BusinessServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: BusinessServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessServiceElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: BusinessPassiveStructureElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def serves(dst: BusinessInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def serves(dst: ApplicationInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	def serves(dst: TechnologyInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	_register(BusinessServiceElement,
		JR.triggers(BusinessServiceElement),
		JR.flowsTo(BusinessServiceElement),
		JR.accesses(BusinessPassiveStructureElement),
		JR.serves(BusinessInternalBehaviorElement),
		JR.serves(BusinessInternalActiveStructureElement),
		JR.triggers(BusinessEventElement),
		JR.flowsTo(BusinessEventElement),
		JR.serves(ApplicationInternalBehaviorElement),
		JR.serves(ApplicationComponentElement),
		JR.serves(TechnologyInternalBehaviorElement),
		JR.serves(NodeElement),
	)

}
