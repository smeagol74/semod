package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationInteractionElement, ApplicationInteractionElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationInteraction(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationInteractionElement {

	object rel extends ApplicationInteractionElementRelationships[ApplicationInteraction] {
		private[archimate] implicit val tt: ApplicationInteraction = ApplicationInteraction.this
	}

}
