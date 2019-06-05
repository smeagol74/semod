package org.opengroup.archimate.meta.element.motivation

import org.opengroup.archimate.meta.element.{ElementName, JR}

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
		JR.specializationOf(RequirementElement)
	)

}
