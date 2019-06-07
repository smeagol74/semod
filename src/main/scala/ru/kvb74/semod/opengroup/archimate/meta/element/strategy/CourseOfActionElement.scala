package ru.kvb74.semod.opengroup.archimate.meta.element.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.OutcomeElement
import ru.kvb74.semod.opengroup.archimate.meta.relationship.Junction

trait CourseOfActionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object CourseOfActionElement
	extends ElementName

trait CourseOfActionElementRelationships[T <: CourseOfActionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def serves(dst: CourseOfActionElement): T = tt._rel.serves(dst)

	def triggers(dst: CourseOfActionElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: CourseOfActionElement, label: String): T = tt._rel.flowsTo(dst, label)

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
