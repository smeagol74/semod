package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationEventElement, ApplicationEventElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationEvent(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationEventElement {

	case class ApplicationEventRelationships(
		private[archimate] implicit val tt: ApplicationEvent = ApplicationEvent.this
	) extends ApplicationEventElementRelationships[ApplicationEvent]

	val rel: ApplicationEventRelationships = ApplicationEventRelationships()

}
