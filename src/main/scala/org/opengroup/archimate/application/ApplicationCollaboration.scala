package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationCollaborationElement, ApplicationCollaborationElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationCollaboration(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationCollaborationElement {

	object rel extends ApplicationCollaborationElementRelationships[ApplicationCollaboration] {
		private[archimate] implicit val tt: ApplicationCollaboration = ApplicationCollaboration.this
	}

}
