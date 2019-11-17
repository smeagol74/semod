package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.{ElementName, RR}

trait AssessmentElement
	extends MotivationElement

case object AssessmentElement
	extends ElementName

trait AssessmentElementProps[T <: AssessmentElement]
	extends MotivationElementProps[T]

trait AssessmentElementRelationships[T <: AssessmentElement]
	extends MotivationElementRelationships[T] {

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: DriverElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: GoalElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	_register(AssessmentElement,
		//		JR.associatedWith(DriverElement),
		//		JR.associatedWith(GoalElement),
		//		JR.associatedWith(ValueElement),
		//		JR.associatedWith(MeaningElement),
	)

}