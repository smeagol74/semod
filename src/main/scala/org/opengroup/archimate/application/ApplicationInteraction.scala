package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationInteractionElement, ApplicationInteractionElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationInteraction(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationInteractionElement {

	case class ApplicationInteractionRelationships(
		private[archimate] implicit val tt: ApplicationInteraction = ApplicationInteraction.this
	) extends ApplicationInteractionElementRelationships[ApplicationInteraction]

	val rel: ApplicationInteractionRelationships = ApplicationInteractionRelationships()

}
