package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{ConstraintElement, ConstraintElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Constraint(
	name: String,
	desc: String = ""
) extends MotivationLayer
	with ConstraintElement {

	case class ConstraintRelationships(
		override private[semod] implicit val tt: Constraint = Constraint.this
	) extends ConstraintElementRelationships[Constraint]

	val rel: ConstraintRelationships = ConstraintRelationships()

	_registerPrefix("MC")
}
