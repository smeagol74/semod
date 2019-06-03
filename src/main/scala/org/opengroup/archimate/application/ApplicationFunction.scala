package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationFunctionElement, ApplicationFunctionElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationFunction(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationFunctionElement {

	object rel extends ApplicationFunctionElementRelationships[ApplicationFunction] {
		private[archimate] implicit val tt: ApplicationFunction = ApplicationFunction.this
	}

}
