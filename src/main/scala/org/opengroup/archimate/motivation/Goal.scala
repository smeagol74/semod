package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{GoalElement, GoalElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

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
