package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyServiceElement, TechnologyServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyService(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with TechnologyServiceElement {

	case class TechnologyServiceRelationships(
		override private[semod] implicit val tt: TechnologyService = TechnologyService.this
	) extends TechnologyServiceElementRelationships[TechnologyService]

	val rel: TechnologyServiceRelationships = TechnologyServiceRelationships()

	_registerPrefix("TS")
}
