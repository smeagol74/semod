package org.opengroup.archimate.application.structure.active

import org.opengroup.archimate.element.ActiveStructureElement
import org.opengroup.archimate.layer.Application

case class ApplicationCollaboration(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Application with ActiveStructureElement {

}
