package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.application.structure.passive.DataObject
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Application, ApplicationInternalBehaviorElement}

case class ApplicationEvent(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationEvent

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationEvent] {
		private[archimate] implicit val tt: ApplicationEvent = ApplicationEvent.this

		def triggers(dst: ApplicationInternalBehaviorElement): ApplicationEvent = tt._rel.triggers(dst)
		def flowsTo(dst: ApplicationInternalBehaviorElement): ApplicationEvent = tt._rel.flowsTo(dst)

		def accesses(dst: DataObject): ApplicationEvent = tt._rel.accesses(dst)

		def triggers(dst: ApplicationService): ApplicationEvent = tt._rel.triggers(dst)
		def flowsTo(dst: ApplicationService): ApplicationEvent = tt._rel.flowsTo(dst)

		def triggers(dst: ApplicationEvent): ApplicationEvent = tt._rel.triggers(dst)
		def flowsTo(dst: ApplicationEvent): ApplicationEvent = tt._rel.flowsTo(dst)
	}

}
