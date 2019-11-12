package ru.kvb74.semod.opengroup.archimate.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.RequirementElement

/**
	* Structure Element / Behavior Element
	* (Strategy & Core)
	*/
trait StrategyCoreStructureBehaviorElement
	extends ArchimateElement

case object StrategyCoreStructureBehaviorElement
	extends ElementName

trait StrategyCoreStructureBehaviorElementRelationships[T <: StrategyCoreStructureBehaviorElement]
	extends ArchimateElementRelationships[T] {

	def influences(dst: RequirementElement, label: String): T = tt._rel.influences(dst, label)

	def realizes(dst: RequirementElement): T = tt._rel.realizes(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	_register(StrategyCoreStructureBehaviorElement,
		RR.influences(RequirementElement),
		RR.realizes(RequirementElement),
		//		JR.associatedWith(ValueElement),
		//		JR.associatedWith(MeaningElement)
	)
}
