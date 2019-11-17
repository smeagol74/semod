package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationCollaborationElement, ApplicationCollaborationElementProps, ApplicationCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationCollaboration(
	name: String
) extends ApplicationLayer
	with ApplicationCollaborationElement {

	case class ApplicationCollaborationRelationships(
		override private[semod] implicit val tt: ApplicationCollaboration = ApplicationCollaboration.this
	) extends ApplicationCollaborationElementRelationships[ApplicationCollaboration]

	val rel: ApplicationCollaborationRelationships = ApplicationCollaborationRelationships()

	case class ApplicationCollaborationProps(
		override private[semod] implicit val tt: ApplicationCollaboration = ApplicationCollaboration.this
	) extends ApplicationCollaborationElementProps[ApplicationCollaboration]

	val prop: ApplicationCollaborationProps = ApplicationCollaborationProps()

	_registerPrefix("AC")
}