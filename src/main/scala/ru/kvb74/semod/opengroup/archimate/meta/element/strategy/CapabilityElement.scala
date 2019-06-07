package ru.kvb74.semod.opengroup.archimate.meta.element.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.relationship.Junction

trait CapabilityElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object CapabilityElement
	extends ElementName

trait CapabilityElementRelationships[T <: CapabilityElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: CourseOfActionElement): T = tt._rel.realizes(dst)

	def serves(dst: CourseOfActionElement): T = tt._rel.serves(dst)

	def serves(dst: CapabilityElement): T = tt._rel.serves(dst)

	def triggers(dst: CapabilityElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: CapabilityElement, label: String): T = tt._rel.flowsTo(dst, label)

	_register(CapabilityElement,
		JR.realizes(CourseOfActionElement),
		JR.serves(CourseOfActionElement),
		JR.serves(CapabilityElement),
		JR.triggers(CapabilityElement),
		JR.flowsTo(CapabilityElement),
	)

}
