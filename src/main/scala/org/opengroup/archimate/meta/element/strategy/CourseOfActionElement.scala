package org.opengroup.archimate.meta.element.strategy

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.motivation.OutcomeElement
import org.opengroup.archimate.meta.relationship.Junction

trait CourseOfActionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object CourseOfActionElement
	extends ElementName

trait CourseOfActionElementRelationships[T <: CourseOfActionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def serves(dst: CourseOfActionElement): T = tt._rel.serves(dst)

	def triggers(dst: CourseOfActionElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: CourseOfActionElement): T = tt._rel.flowsTo(dst)

	def realizes(dst: OutcomeElement): T = tt._rel.realizes(dst)

	def influences(dst: OutcomeElement, label: String = ""): T = tt._rel.influences(dst, label)

	_register(CourseOfActionElement,
		JR.serves(CourseOfActionElement),
		JR.triggers(CourseOfActionElement),
		JR.flowsTo(CourseOfActionElement),
		JR.realizes(OutcomeElement),
		JR.influences(OutcomeElement),
	)
}
