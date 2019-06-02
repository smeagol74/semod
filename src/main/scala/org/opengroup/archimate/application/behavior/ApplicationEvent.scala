package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.Application

case class ApplicationEvent(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationEvent
}
