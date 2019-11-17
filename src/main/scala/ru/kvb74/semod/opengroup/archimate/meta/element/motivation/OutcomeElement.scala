package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.{ElementName, RR}

trait OutcomeElement
	extends MotivationElement

case object OutcomeElement
	extends ElementName

trait OutcomeElementProps[T <: OutcomeElement]
	extends MotivationElementProps[T]

trait OutcomeElementRelationships[T <: OutcomeElement]
	extends MotivationElementRelationships[T] {

	def realizes(dst: GoalElement): T = tt._rel.realizes(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	_register(OutcomeElement,
		RR.realizes(GoalElement),
		//		JR.associatedWith(ValueElement)
	)

}
