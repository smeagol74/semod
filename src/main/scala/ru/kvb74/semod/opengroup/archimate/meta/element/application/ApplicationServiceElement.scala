package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, Junction, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessInternalActiveStructureElement, BusinessInternalBehaviorElement, BusinessServiceElement, BusinessServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{NodeElement, TechnologyInternalBehaviorElement}

trait ApplicationServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationServiceElement
	extends ElementName

trait ApplicationServiceElementProps[T <: ApplicationServiceElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationServiceElementRelationships[T <: ApplicationServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: ApplicationServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationServiceElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: ApplicationEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def flowsTo(dst: ApplicationEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: DataObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def serves(dst: ApplicationInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def realizes(dst: BusinessServiceElement): T = tt._rel.realizes(dst)

	def serves(dst: TechnologyInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	_register(ApplicationServiceElement,
		RR.triggers(ApplicationServiceElement),
		RR.flowsTo(ApplicationServiceElement),
		RR.triggers(ApplicationEventElement),
		RR.flowsTo(ApplicationEventElement),
		RR.accesses(DataObjectElement),
		RR.serves(ApplicationInternalBehaviorElement),
		RR.serves(ApplicationComponentElement),
		RR.serves(BusinessInternalBehaviorElement),
		RR.serves(BusinessInternalActiveStructureElement),
		RR.realizes(BusinessServiceElement),
		RR.serves(TechnologyInternalBehaviorElement),
		RR.serves(NodeElement),
	)

}