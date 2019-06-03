package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{ConstraintElement, ConstraintElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Constraint(
	name: String,
	desc: String = ""
) extends Motivation
	with ConstraintElement {

	object rel extends ConstraintElementRelationships[Constraint] {
		override private[archimate] implicit val tt: Constraint = Constraint.this
	}

}
