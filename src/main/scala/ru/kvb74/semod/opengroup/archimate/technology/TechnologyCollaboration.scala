package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyCollaborationElement, TechnologyCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyCollaboration(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with TechnologyCollaborationElement {

	case class TechnologyCollaborationRelationships(
		override private[semod] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this
	) extends TechnologyCollaborationElementRelationships[TechnologyCollaboration]

	val rel: TechnologyCollaborationRelationships = TechnologyCollaborationRelationships()

	_registerPrefix("TC")
}
