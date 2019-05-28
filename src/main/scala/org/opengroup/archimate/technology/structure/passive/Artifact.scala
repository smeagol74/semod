package org.opengroup.archimate.technology.structure.passive

import org.opengroup.archimate.element.PassiveStructureElement
import org.opengroup.archimate.layer.Technology

case class Artifact(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Technology with PassiveStructureElement {

}
