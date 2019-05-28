package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.element.BehaviorElement
import org.opengroup.archimate.layer.Application

case class ApplicationService(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Application with BehaviorElement {

}
