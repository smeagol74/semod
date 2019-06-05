package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationComponentElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationComponent(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationComponentElement {

	case class ApplicationComponentRelationships(
		private[archimate] implicit val tt: ApplicationComponent = ApplicationComponent.this
	) extends ApplicationComponentElementRelationships[ApplicationComponent]

	val rel: ApplicationComponentRelationships = ApplicationComponentRelationships()

}
