package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{ConstraintElement, ConstraintElementProps, ConstraintElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Constraint(
	name: String
) extends MotivationLayer
	with ConstraintElement {

	case class ConstraintRelationships(
		override private[semod] implicit val tt: Constraint = Constraint.this
	) extends ConstraintElementRelationships[Constraint]

	val rel: ConstraintRelationships = ConstraintRelationships()

	case class ConstraintProps(
		override private[semod] implicit val tt: Constraint = Constraint.this
	) extends ConstraintElementProps[Constraint]

	val prop: ConstraintProps = ConstraintProps()

	_registerPrefix("MC")
}
