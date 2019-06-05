package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{ApplicationCollaborationElement, ApplicationCollaborationElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class ApplicationCollaboration(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationCollaborationElement {

	case class ApplicationCollaborationRelationships(
		private[archimate] implicit val tt: ApplicationCollaboration = ApplicationCollaboration.this
	) extends ApplicationCollaborationElementRelationships[ApplicationCollaboration]

	val rel: ApplicationCollaborationRelationships = ApplicationCollaborationRelationships()

}
