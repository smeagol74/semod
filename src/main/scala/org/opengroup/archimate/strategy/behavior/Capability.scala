package org.opengroup.archimate.strategy.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Strategy

case class Capability(
	name: String,
	desc: String = ""
) extends Strategy with BehaviorElement with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.strategy.capability

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Capability] {

		private[archimate] implicit val tt: Capability = Capability.this

		def realizes(dst: CourseOfAction): Capability = tt._rel.realizes(dst)

		def serves(dst: CourseOfAction): Capability = tt._rel.serves(dst)

		def serves(dst: Capability): Capability = tt._rel.serves(dst)

		def triggers(dst: Capability): Capability = tt._rel.triggers(dst)

		def flowsTo(dst: Capability): Capability = tt._rel.flowsTo(dst)

	}

}
