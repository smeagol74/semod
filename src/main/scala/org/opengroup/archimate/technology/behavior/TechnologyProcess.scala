package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Physical, Technology}

case class TechnologyProcess(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {

}
