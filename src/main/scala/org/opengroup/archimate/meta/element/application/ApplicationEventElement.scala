package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.relationship.Junction

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

	def accesses(dst: DataObjectElement): T = tt._rel.accesses(dst)

	def flowsTo(dst: ApplicationEventElement): T = tt._rel.flowsTo(dst)

	def flowsTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def flowsTo(dst: ApplicationServiceElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: ApplicationEventElement): T = tt._rel.triggers(dst)

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def triggers(dst: ApplicationServiceElement): T = tt._rel.triggers(dst)

	_register(ApplicationEventElement,
		JR.accesses(DataObjectElement),
		JR.flowsTo(ApplicationEventElement),
		JR.flowsTo(ApplicationInternalBehaviorElement),
		JR.flowsTo(ApplicationServiceElement),
		JR.triggers(ApplicationEventElement),
		JR.triggers(ApplicationInternalBehaviorElement),
		JR.triggers(ApplicationServiceElement),
	)

}