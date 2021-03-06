package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element.StrategyCoreStructureBehaviorElement

trait ValueElement
	extends MotivationElement

case object ValueElement
	extends ElementName

trait ValueElementProps[T <: ValueElement]
	extends MotivationElementProps[T]

trait ValueElementRelationships[T <: ValueElement]
	extends MotivationElementRelationships[T] {

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: StakeholderElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: OutcomeElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.associatedWith(dst)

	_register(ValueElement,
		//		JR.associatedWith(StakeholderElement),
		//		JR.associatedWith(OutcomeElement),
		//		JR.associatedWith(StrategyCoreStructureBehaviorElement),
	)

}
