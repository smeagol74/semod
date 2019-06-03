package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationComponentElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationComponent(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationComponentElement {

	object rel extends ApplicationComponentElementRelationships[ApplicationComponent] {
		private[archimate] implicit val tt: ApplicationComponent = ApplicationComponent.this
	}

}
