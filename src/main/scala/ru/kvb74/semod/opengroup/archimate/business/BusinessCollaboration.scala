package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessCollaborationElement, BusinessCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessCollaboration(
	name: String,
	desc: String = ""
) extends BusinessLayer
	with BusinessCollaborationElement {

	case class BusinessCollaborationRelationships(
		override private[semod] implicit val tt: BusinessCollaboration = BusinessCollaboration.this
	) extends BusinessCollaborationElementRelationships[BusinessCollaboration]

	val rel: BusinessCollaborationRelationships = BusinessCollaborationRelationships()

	_registerPrefix("BC")
}
