package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.Technology

case class Path(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.path
}
