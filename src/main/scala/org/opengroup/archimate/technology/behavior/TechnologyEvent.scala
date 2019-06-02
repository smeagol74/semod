package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyInternalBehaviorElement, TechnologyObjectElement}

case class TechnologyEvent(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyEvent

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyEvent] {
		private[archimate] implicit val tt: TechnologyEvent = TechnologyEvent.this

		def triggers(dst: TechnologyInternalBehaviorElement): TechnologyEvent = tt._rel.triggers(dst)
		def flowsTo(dst: TechnologyInternalBehaviorElement): TechnologyEvent = tt._rel.flowsTo(dst)

		def accesses(dst: TechnologyObjectElement): TechnologyEvent = tt._rel.accesses(dst)

		def triggers(dst: TechnologyEvent): TechnologyEvent = tt._rel.triggers(dst)
		def flowsTo(dst: TechnologyEvent): TechnologyEvent = tt._rel.flowsTo(dst)

		def triggers(dst: TechnologyService): TechnologyEvent = tt._rel.triggers(dst)
		def flowsTo(dst: TechnologyService): TechnologyEvent = tt._rel.flowsTo(dst)
	}

}
