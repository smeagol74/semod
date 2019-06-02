package org.opengroup.archimate.application.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.Application

case class ApplicationCollaboration(
	name: String,
	desc: String = ""
) extends Application
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationCollaboration
}
