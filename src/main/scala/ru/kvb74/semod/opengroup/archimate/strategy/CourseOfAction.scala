package ru.kvb74.semod.opengroup.archimate.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element.strategy.{CourseOfActionElement, CourseOfActionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Strategy

case class CourseOfAction(
	name: String,
	desc: String = ""
) extends Strategy
	with CourseOfActionElement {

	case class CourseOfActionRelationships(
		override private[archimate] implicit val tt: CourseOfAction = CourseOfAction.this
	) extends CourseOfActionElementRelationships[CourseOfAction]

	val rel: CourseOfActionRelationships = CourseOfActionRelationships()

}
