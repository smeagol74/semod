package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyInteractionElement, TechnologyInteractionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class TechnologyInteraction(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyInteractionElement {

	case class TechnologyInteractionRelationships(
		override private[archimate] implicit val tt: TechnologyInteraction = TechnologyInteraction.this
	) extends TechnologyInteractionElementRelationships[TechnologyInteraction]

	val rel: TechnologyInteractionRelationships = TechnologyInteractionRelationships()

}
