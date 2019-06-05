package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.relationship.Junction

trait ApplicationServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationServiceElement
	extends ElementName

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationServiceElementRelationships[T <: ApplicationServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: ApplicationServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationServiceElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: ApplicationEventElement): T = tt._rel.flowsTo(dst)

	def flowsTo(dst: ApplicationEventElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: DataObjectElement): T = tt._rel.accesses(dst)

	def serves(dst: ApplicationInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	_register(ApplicationServiceElement,
		JR.triggers(ApplicationServiceElement),
		JR.flowsTo(ApplicationServiceElement),
		JR.triggers(ApplicationEventElement),
		JR.flowsTo(ApplicationEventElement),
		JR.accesses(DataObjectElement),
		JR.serves(ApplicationInternalBehaviorElement),
		JR.serves(ApplicationComponentElement),
	)

}