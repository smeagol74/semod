package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{ElementName, JR}

trait DriverElement
	extends MotivationElement

case object DriverElement
	extends ElementName

trait DriverElementRelationships[T <: DriverElement]
	extends MotivationElementRelationships[T] {

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: AssessmentElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: GoalElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	_register(DriverElement,
		//		JR.associatedWith(AssessmentElement),
		//		JR.associatedWith(GoalElement),
		//		JR.associatedWith(ValueElement),
		//		JR.associatedWith(MeaningElement),
	)

}
