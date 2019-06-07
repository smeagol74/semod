package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{ElementName, JR}

trait AssessmentElement
	extends MotivationElement

case object AssessmentElement
	extends ElementName

trait AssessmentElementRelationships[T <: AssessmentElement]
	extends MotivationElementRelationships[T] {

	def associatedWith(dst: DriverElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: GoalElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	_register(AssessmentElement,
		JR.associatedWith(DriverElement),
		JR.associatedWith(GoalElement),
		JR.associatedWith(ValueElement),
		JR.associatedWith(MeaningElement),
	)

}