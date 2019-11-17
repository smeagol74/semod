package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessCollaborationElement, BusinessCollaborationElementProps, BusinessCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessCollaboration(
	name: String
) extends BusinessLayer
	with BusinessCollaborationElement {

	case class BusinessCollaborationRelationships(
		override private[semod] implicit val tt: BusinessCollaboration = BusinessCollaboration.this
	) extends BusinessCollaborationElementRelationships[BusinessCollaboration]

	val rel: BusinessCollaborationRelationships = BusinessCollaborationRelationships()

	case class BusinessCollaborationProps(
		override private[semod] implicit val tt: BusinessCollaboration = BusinessCollaboration.this
	) extends BusinessCollaborationElementProps[BusinessCollaboration]

	val prop: BusinessCollaborationProps = BusinessCollaborationProps()

	_registerPrefix("BC")
}
