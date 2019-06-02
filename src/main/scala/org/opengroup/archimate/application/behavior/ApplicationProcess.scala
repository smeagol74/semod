package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationProcess(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationProcess

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationProcess] {
		private[archimate] implicit val tt: ApplicationProcess = ApplicationProcess.this
	}

}
