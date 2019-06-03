package org.opengroup.archimate.meta.element.motivation

trait ConstraintElement
	extends MotivationElement

trait ConstraintElementRelationships[T <: ConstraintElement]
	extends MotivationElementRelationships[T] {
	def isSpecializationOf(dst: RequirementElement): T = tt._rel.isSpecializationOf(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

}
