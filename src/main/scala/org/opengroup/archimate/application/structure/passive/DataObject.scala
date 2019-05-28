package org.opengroup.archimate.application.structure.passive

import org.opengroup.archimate.element.PassiveStructureElement
import org.opengroup.archimate.layer.Application

case class DataObject(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Application with PassiveStructureElement {

}
