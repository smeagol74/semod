package org.opengroup.archimate.strategy

import org.opengroup.archimate.meta.element.strategy.{CourseOfActionElement, CourseOfActionElementRelationships}
import org.opengroup.archimate.meta.layer.Strategy

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
