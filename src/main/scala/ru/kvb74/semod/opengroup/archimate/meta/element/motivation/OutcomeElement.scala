package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{ElementName, JR}

trait OutcomeElement
	extends MotivationElement

case object OutcomeElement
	extends ElementName

trait OutcomeElementRelationships[T <: OutcomeElement]
	extends MotivationElementRelationships[T] {

	def realizes(dst: GoalElement): T = tt._rel.realizes(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	_register(OutcomeElement,
		JR.realizes(GoalElement),
		JR.associatedWith(ValueElement)
	)

}
