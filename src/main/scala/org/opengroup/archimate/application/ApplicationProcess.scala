package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationProcessElement, ApplicationProcessElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationProcess(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationProcessElement {

	object rel extends ApplicationProcessElementRelationships[ApplicationProcess] {
		private[archimate] implicit val tt: ApplicationProcess = ApplicationProcess.this
	}

}
