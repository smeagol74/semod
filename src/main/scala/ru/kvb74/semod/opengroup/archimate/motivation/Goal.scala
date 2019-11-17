package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{GoalElement, GoalElementProps, GoalElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Goal(
	name: String
) extends MotivationLayer
	with GoalElement {

	case class GoalRelationships(
		override private[semod] implicit val tt: Goal = Goal.this
	) extends GoalElementRelationships[Goal]

	val rel: GoalRelationships = GoalRelationships()

	case class GoalProps(
		override private[semod] implicit val tt: Goal = Goal.this
	) extends GoalElementProps[Goal]

	val prop: GoalProps = GoalProps()

	_registerPrefix("MG")
}
