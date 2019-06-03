package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

trait BusinessEventElementRelationships[T <: BusinessEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: BusinessServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessServiceElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: BusinessPassiveStructureElement): T = tt._rel.accesses(dst)

}
