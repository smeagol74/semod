package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, Junction, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait ApplicationEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationEventElement
	extends ElementName

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationEventElementRelationships[T <: ApplicationEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def accesses(dst: DataObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def flowsTo(dst: ApplicationEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def flowsTo(dst: ApplicationInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def flowsTo(dst: ApplicationServiceElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: ApplicationEventElement): T = tt._rel.triggers(dst)

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def triggers(dst: ApplicationServiceElement): T = tt._rel.triggers(dst)

	_register(ApplicationEventElement,
		RR.accesses(DataObjectElement),
		RR.flowsTo(ApplicationEventElement),
		RR.flowsTo(ApplicationInternalBehaviorElement),
		RR.flowsTo(ApplicationServiceElement),
		RR.triggers(ApplicationEventElement),
		RR.triggers(ApplicationInternalBehaviorElement),
		RR.triggers(ApplicationServiceElement),
	)

}