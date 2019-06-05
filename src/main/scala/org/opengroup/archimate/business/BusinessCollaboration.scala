package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessCollaborationElement, BusinessCollaborationElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessCollaboration(
	name: String,
	desc: String = ""
) extends Business
	with BusinessCollaborationElement {

	case class BusinessCollaborationRelationships(
		override private[archimate] implicit val tt: BusinessCollaboration = BusinessCollaboration.this
	) extends BusinessCollaborationElementRelationships[BusinessCollaboration]

	val rel: BusinessCollaborationRelationships = BusinessCollaborationRelationships()

}
