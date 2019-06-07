package ru.kvb74.semod.opengroup.archimate.meta.element

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{MeaningElement, RequirementElement, ValueElement}

/**
	* Structure Element / Behavior Element
	* (Strategy & Core)
	*/
trait StrategyCoreStructureBehaviorElement
	extends Element

case object StrategyCoreStructureBehaviorElement
	extends ElementName

trait StrategyCoreStructureBehaviorElementRelationships[T <: StrategyCoreStructureBehaviorElement]
	extends ElementRelationships[T] {

	def influences(dst: RequirementElement, label: String): T = tt._rel.influences(dst, label)

	def realizes(dst: RequirementElement): T = tt._rel.realizes(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	_register(StrategyCoreStructureBehaviorElement,
		JR.influences(RequirementElement),
		JR.realizes(RequirementElement),
		JR.associatedWith(ValueElement),
		JR.associatedWith(MeaningElement)
	)
}
