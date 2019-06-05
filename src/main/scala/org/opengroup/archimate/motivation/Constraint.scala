package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{ConstraintElement, ConstraintElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Constraint(
	name: String,
	desc: String = ""
) extends Motivation
	with ConstraintElement {

	case class ConstraintRelationships(
		override private[archimate] implicit val tt: Constraint = Constraint.this
	) extends ConstraintElementRelationships[Constraint]

	val rel: ConstraintRelationships = ConstraintRelationships()

}
