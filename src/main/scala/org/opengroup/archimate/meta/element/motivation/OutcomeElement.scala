package org.opengroup.archimate.meta.element.motivation

trait OutcomeElement
	extends MotivationElement

trait OutcomeElementRelationships[T <: OutcomeElement]
	extends MotivationElementRelationships[T] {
	def realizes(dst: GoalElement): T = tt._rel.realizes(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)
}
