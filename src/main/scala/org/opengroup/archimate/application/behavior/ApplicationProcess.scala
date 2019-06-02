package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Application, ApplicationInternalBehaviorElement, ApplicationInternalBehaviorElementRelationships}

case class ApplicationProcess(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement
	with ApplicationInternalBehaviorElement {
	val id: String = IdGenerator.application.applicationProcess

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationProcess]
		with ApplicationInternalBehaviorElementRelationships[ApplicationProcess] {
		private[archimate] implicit val tt: ApplicationProcess = ApplicationProcess.this
	}

}
