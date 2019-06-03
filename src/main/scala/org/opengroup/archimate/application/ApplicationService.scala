package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationServiceElement, ApplicationServiceRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationService(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationServiceElement {

	object rel extends ApplicationServiceRelationships[ApplicationService] {
		private[archimate] implicit val tt: ApplicationService = ApplicationService.this
	}

}
