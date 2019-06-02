package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.Application

case class ApplicationInteraction(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {

}
