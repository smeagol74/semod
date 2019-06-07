package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationCollaborationElement, ApplicationCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

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
