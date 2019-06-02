package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Application, ApplicationInternalBehaviorElement, ApplicationInternalBehaviorElementRelationships}

case class ApplicationFunction(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with ApplicationInternalBehaviorElement {
	val id: String = IdGenerator.application.applicationFunction

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationFunction]
		with ApplicationInternalBehaviorElementRelationships[ApplicationFunction] {
		private[archimate] implicit val tt: ApplicationFunction = ApplicationFunction.this
	}

}
