package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

trait BusinessServiceElementRelationships[T <: BusinessServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def triggers(dst: BusinessServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessServiceElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: BusinessPassiveStructureElement): T = tt._rel.accesses(dst)

	def serves(dst: BusinessInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement): T = tt._rel.flowsTo(dst)
}
