package org.opengroup.archimate.application.structure.active

import org.opengroup.archimate.element.{ActiveStructureElement, ElementRelationships, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationInterface(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Application
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationInterface] {
		override private[archimate] implicit val tt: ApplicationInterface = ApplicationInterface.this
	}

}
