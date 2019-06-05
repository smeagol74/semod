package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.relationship.Junction

trait BusinessServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object BusinessServiceElement
	extends ElementName

trait BusinessServiceElementRelationships[T <: BusinessServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: BusinessServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessServiceElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: BusinessPassiveStructureElement): T = tt._rel.accesses(dst)

	def serves(dst: BusinessInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement): T = tt._rel.flowsTo(dst)

	_register(BusinessServiceElement,
		JR.triggers(BusinessServiceElement),
		JR.flowsTo(BusinessServiceElement),
		JR.accesses(BusinessPassiveStructureElement),
		JR.serves(BusinessInternalBehaviorElement),
		JR.serves(BusinessInternalActiveStructureElement),
		JR.triggers(BusinessEventElement),
		JR.flowsTo(BusinessEventElement),
	)

}
