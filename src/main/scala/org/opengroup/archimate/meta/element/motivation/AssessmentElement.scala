package org.opengroup.archimate.meta.element.motivation

trait AssessmentElement
	extends MotivationElement

trait AssessmentElementRelationships[T <: AssessmentElement]
	extends MotivationElementRelationships[T] {
	def associatedWith(dst: DriverElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: GoalElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)
}