package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyCollaborationElement, TechnologyCollaborationElementProps, TechnologyCollaborationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyCollaboration(
	name: String
) extends TechnologyLayer
	with TechnologyCollaborationElement {

	case class TechnologyCollaborationRelationships(
		override private[semod] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this
	) extends TechnologyCollaborationElementRelationships[TechnologyCollaboration]

	val rel: TechnologyCollaborationRelationships = TechnologyCollaborationRelationships()

	case class TechnologyCollaborationProps(
		override private[semod] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this
	) extends TechnologyCollaborationElementProps[TechnologyCollaboration]

	val prop: TechnologyCollaborationProps = TechnologyCollaborationProps()

	_registerPrefix("TC")
}
