package org.opengroup.archimate.meta.element.motivation

trait GoalElement
	extends MotivationElement

trait GoalElementRelationships[T <: GoalElement]
	extends MotivationElementRelationships[T] {
	def associatedWith(dst: AssessmentElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: DriverElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

}
