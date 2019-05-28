package org.opengroup.archimate.physical.structure.passive

import org.opengroup.archimate.element.PassiveStructureElement
import org.opengroup.archimate.layer.Physical

case class Material(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Physical with PassiveStructureElement {

}
