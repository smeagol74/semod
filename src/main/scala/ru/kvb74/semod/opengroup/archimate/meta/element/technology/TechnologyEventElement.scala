package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait TechnologyEventElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyEventElement
	extends ElementName

trait TechnologyEventElementRelationships[T <: TechnologyEventElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: TechnologyObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: TechnologyServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyServiceElement, label: String): T = tt._rel.flowsTo(dst, label)

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