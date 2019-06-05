package org.opengroup.archimate.meta.element.strategy

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.relationship.Junction

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

	def flowsTo(dst: CapabilityElement): T = tt._rel.flowsTo(dst)

	_register(CapabilityElement,
		JR.realizes(CourseOfActionElement),
		JR.serves(CourseOfActionElement),
		JR.serves(CapabilityElement),
		JR.triggers(CapabilityElement),
		JR.flowsTo(CapabilityElement),
	)

}
