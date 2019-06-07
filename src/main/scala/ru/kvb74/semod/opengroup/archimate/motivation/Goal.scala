package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{GoalElement, GoalElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Goal(
	name: String,
	desc: String = ""
) extends Motivation
	with GoalElement {

	case class GoalRelationships(
		override private[archimate] implicit val tt: Goal = Goal.this
	) extends GoalElementRelationships[Goal]

	val rel: GoalRelationships = GoalRelationships()

}
