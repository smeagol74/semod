package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ApplicationEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationEventElementRelationships[T <: ApplicationEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: DataObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: ApplicationServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationServiceElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: ApplicationEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationEventElement): T = tt._rel.flowsTo(dst)
}