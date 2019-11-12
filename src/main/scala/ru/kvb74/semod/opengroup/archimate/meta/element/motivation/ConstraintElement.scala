package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.{ElementName, RR}

trait ConstraintElement
	extends MotivationElement
		with RequirementElement

case object ConstraintElement
	extends ElementName

trait ConstraintElementRelationships[T <: ConstraintElement]
	extends MotivationElementRelationships[T]
		with RequirementElementRelationships[T] {

	def specializationOf(dst: RequirementElement): T = tt._rel.specializationOf(dst)

	_register(ConstraintElement,
		RR.specializationOf(RequirementElement)
	)

}
