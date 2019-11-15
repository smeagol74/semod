package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyEventElement, TechnologyEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyEvent(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with TechnologyEventElement {

	case class TechnologyEventRelationships(
		override private[semod] implicit val tt: TechnologyEvent = TechnologyEvent.this
	) extends TechnologyEventElementRelationships[TechnologyEvent]

	val rel: TechnologyEventRelationships = TechnologyEventRelationships()

	_registerPrefix("TE")
}
