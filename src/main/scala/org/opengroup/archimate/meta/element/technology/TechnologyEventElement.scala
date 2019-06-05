package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait TechnologyEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyEventElement
	extends ElementName

trait TechnologyEventElementRelationships[T <: TechnologyEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: TechnologyObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: TechnologyServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyServiceElement): T = tt._rel.flowsTo(dst)

	_register(TechnologyEventElement,
		JR.triggers(TechnologyInternalBehaviorElement),
		JR.flowsTo(TechnologyInternalBehaviorElement),
		JR.accesses(TechnologyObjectElement),
		JR.triggers(TechnologyEventElement),
		JR.flowsTo(TechnologyEventElement),
		JR.triggers(TechnologyServiceElement),
		JR.flowsTo(TechnologyServiceElement),
	)
}