package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationInterfaceElement, ApplicationInterfaceElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationInterface(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationInterfaceElement {

	object rel extends ApplicationInterfaceElementRelationships[ApplicationInterface] {
		override private[archimate] implicit val tt: ApplicationInterface = ApplicationInterface.this
	}

}
