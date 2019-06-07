package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyCollaborationElement, TechnologyCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class TechnologyCollaboration(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyCollaborationElement {

	case class TechnologyCollaborationRelationships(
		override private[archimate] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this
	) extends TechnologyCollaborationElementRelationships[TechnologyCollaboration]

	val rel: TechnologyCollaborationRelationships = TechnologyCollaborationRelationships()

}
