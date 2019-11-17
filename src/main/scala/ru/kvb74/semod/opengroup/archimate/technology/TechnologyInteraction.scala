package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyInteractionElement, TechnologyInteractionElementProps, TechnologyInteractionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyInteraction(
	name: String
) extends TechnologyLayer
	with TechnologyInteractionElement {

	case class TechnologyInteractionRelationships(
		override private[semod] implicit val tt: TechnologyInteraction = TechnologyInteraction.this
	) extends TechnologyInteractionElementRelationships[TechnologyInteraction]

	val rel: TechnologyInteractionRelationships = TechnologyInteractionRelationships()

	case class TechnologyInteractionProps(
		override private[semod] implicit val tt: TechnologyInteraction = TechnologyInteraction.this
	) extends TechnologyInteractionElementProps[TechnologyInteraction]

	val prop: TechnologyInteractionProps = TechnologyInteractionProps()

	_registerPrefix("TI")
}
