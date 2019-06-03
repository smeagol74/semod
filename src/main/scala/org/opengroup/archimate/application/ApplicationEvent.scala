package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationEventElement, ApplicationEventElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationEvent(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationEventElement {

	object rel extends ApplicationEventElementRelationships[ApplicationEvent] {
		private[archimate] implicit val tt: ApplicationEvent = ApplicationEvent.this
	}

}
