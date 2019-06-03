package org.opengroup.archimate.meta.element.motivation

trait PrincipleElement
	extends MotivationElement

trait PrincipleElementRelationships[T <: PrincipleElement]
	extends MotivationElementRelationships[T] {
	def realizes(dst: OutcomeElement): T = tt._rel.realizes(dst)

	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

}
