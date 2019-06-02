package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.Technology

case class SystemSoftware(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {

}
