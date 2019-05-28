package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.element.BehaviorElement
import org.opengroup.archimate.layer.{Physical, Technology}

case class TechnologyFunction(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Technology with Physical with BehaviorElement {

}
