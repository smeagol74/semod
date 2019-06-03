package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

trait TechnologyEventElementRelationships[T <: TechnologyEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: TechnologyObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: TechnologyServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyServiceElement): T = tt._rel.flowsTo(dst)

}
