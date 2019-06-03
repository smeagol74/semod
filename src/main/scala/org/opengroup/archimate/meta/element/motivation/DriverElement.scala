package org.opengroup.archimate.meta.element.motivation

trait DriverElement
	extends MotivationElement

trait DriverElementRelationships[T <: DriverElement]
	extends MotivationElementRelationships[T] {
	def associatedWith(dst: AssessmentElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: GoalElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)
}
