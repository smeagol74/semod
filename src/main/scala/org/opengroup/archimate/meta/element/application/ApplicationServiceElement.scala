package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.business.{BusinessInternalActiveStructureElement, BusinessInternalBehaviorElement, BusinessServiceElement, BusinessServiceElementRelationships}
import org.opengroup.archimate.meta.element.technology.{NodeElement, TechnologyInternalBehaviorElement}
import org.opengroup.archimate.meta.relationship.Junction
import org.opengroup.archimate.relationship.dependency.AccessMode

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
		JR.triggers(ApplicationServiceElement),
		JR.flowsTo(ApplicationServiceElement),
		JR.triggers(ApplicationEventElement),
		JR.flowsTo(ApplicationEventElement),
		JR.accesses(DataObjectElement),
		JR.serves(ApplicationInternalBehaviorElement),
		JR.serves(ApplicationComponentElement),
		JR.serves(BusinessInternalBehaviorElement),
		JR.serves(BusinessInternalActiveStructureElement),
		JR.realizes(BusinessServiceElement),
		JR.serves(TechnologyInternalBehaviorElement),
		JR.serves(NodeElement),
	)

}