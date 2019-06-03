package org.opengroup.archimate.meta.element.strategy

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait CapabilityElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

trait CapabilityElementRelationships[T <: CapabilityElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def realizes(dst: CourseOfActionElement): T = tt._rel.realizes(dst)

	def serves(dst: CourseOfActionElement): T = tt._rel.serves(dst)

	def serves(dst: CapabilityElement): T = tt._rel.serves(dst)

	def triggers(dst: CapabilityElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: CapabilityElement): T = tt._rel.flowsTo(dst)

}
