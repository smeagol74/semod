package ru.kvb74.semod.opengroup.archimate.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element.strategy.{CourseOfActionElement, CourseOfActionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.StrategyLayer

case class CourseOfAction(
	name: String,
	desc: String = ""
) extends StrategyLayer
	with CourseOfActionElement {

	case class CourseOfActionRelationships(
		override private[semod] implicit val tt: CourseOfAction = CourseOfAction.this
	) extends CourseOfActionElementRelationships[CourseOfAction]

	val rel: CourseOfActionRelationships = CourseOfActionRelationships()

	_registerPrefix("SCOA")
}
