package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationInteraction(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationInteraction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationInteraction] {
		private[archimate] implicit val tt: ApplicationInteraction = ApplicationInteraction.this
	}

}
