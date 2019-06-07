package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class TechnologyObject(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyObjectElement {

	case class TechnologyObjectRelationships(
		override private[archimate] implicit val tt: TechnologyObject = TechnologyObject.this
	) extends TechnologyObjectElementRelationships[TechnologyObject]

	val rel: TechnologyObjectRelationships = TechnologyObjectRelationships()

}
