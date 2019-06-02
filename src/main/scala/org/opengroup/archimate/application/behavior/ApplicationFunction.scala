package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationFunction(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationFunction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationFunction] {
		private[archimate] implicit val tt: ApplicationFunction = ApplicationFunction.this
	}
}
