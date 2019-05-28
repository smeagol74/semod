package org.opengroup.archimate.strategy.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Strategy
import org.opengroup.archimate.motivation.Outcome

case class CourseOfAction(
	name: String,
	desc: String = ""
) extends Strategy with BehaviorElement with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.strategy.courseOfAction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[CourseOfAction] {

		private[archimate] implicit val tt: CourseOfAction = CourseOfAction.this

		def serves(dst: CourseOfAction): CourseOfAction = tt._rel.serves(dst)

		def triggers(dst: CourseOfAction): CourseOfAction = tt._rel.triggers(dst)

		def flowsTo(dst: CourseOfAction): CourseOfAction = tt._rel.flowsTo(dst)

		def realizes(dst: Outcome): CourseOfAction = tt._rel.realizes(dst)

		def influences(dst: Outcome, label: String = ""): CourseOfAction = tt._rel.influences(dst, label)

	}

}
