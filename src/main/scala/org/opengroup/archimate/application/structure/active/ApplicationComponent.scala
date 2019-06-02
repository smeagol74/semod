package org.opengroup.archimate.application.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationComponent(
	name: String,
	desc: String = ""
) extends Application
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationComponent

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationComponent] {
		private[archimate] implicit val tt: ApplicationComponent = ApplicationComponent.this
	}

}
