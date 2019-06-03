package org.opengroup.archimate.meta.element.strategy

import org.opengroup.archimate.meta.element.motivation.OutcomeElement
import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait CourseOfActionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

trait CourseOfActionElementRelationships[T <: CourseOfActionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def serves(dst: CourseOfActionElement): T = tt._rel.serves(dst)

	def triggers(dst: CourseOfActionElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: CourseOfActionElement): T = tt._rel.flowsTo(dst)

	def realizes(dst: OutcomeElement): T = tt._rel.realizes(dst)

	def influences(dst: OutcomeElement, label: String = ""): T = tt._rel.influences(dst, label)
}
