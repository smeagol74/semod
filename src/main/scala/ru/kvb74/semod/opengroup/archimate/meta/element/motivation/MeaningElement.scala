package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{ElementName, JR, StrategyCoreStructureBehaviorElement}

trait MeaningElement
	extends MotivationElement

case object MeaningElement
	extends ElementName

trait MeaningElementRelationships[T <: MeaningElement]
	extends MotivationElementRelationships[T] {

	def associatedWith(dst: StakeholderElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.associatedWith(dst)

	_register(MeaningElement,
		JR.associatedWith(StakeholderElement),
		JR.associatedWith(StrategyCoreStructureBehaviorElement)
	)

}
