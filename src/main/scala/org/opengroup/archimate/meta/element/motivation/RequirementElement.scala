package org.opengroup.archimate.meta.element.motivation

trait RequirementElement
	extends MotivationElement

trait RequirementElementRelationships[T <: RequirementElement]
	extends MotivationElementRelationships[T] {
	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	def realizes(dst: PrincipleElement): T = tt._rel.realizes(dst)

	def realizes(dst: OutcomeElement): T = tt._rel.realizes(dst)

}
