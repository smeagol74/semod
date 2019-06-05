package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationFunctionElement, ApplicationFunctionElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationFunction(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationFunctionElement {

	case class ApplicationFunctionRelationships(
		private[archimate] implicit val tt: ApplicationFunction = ApplicationFunction.this
	) extends ApplicationFunctionElementRelationships[ApplicationFunction]

	val rel: ApplicationFunctionRelationships = ApplicationFunctionRelationships()

}
