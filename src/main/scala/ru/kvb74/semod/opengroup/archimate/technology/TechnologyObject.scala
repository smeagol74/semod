package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyObjectElementProps, TechnologyObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyObject(
	name: String
) extends TechnologyLayer
	with TechnologyObjectElement {

	case class TechnologyObjectRelationships(
		override private[semod] implicit val tt: TechnologyObject = TechnologyObject.this
	) extends TechnologyObjectElementRelationships[TechnologyObject]

	val rel: TechnologyObjectRelationships = TechnologyObjectRelationships()

	case class TechnologyObjectProps(
		override private[semod] implicit val tt: TechnologyObject = TechnologyObject.this
	) extends TechnologyObjectElementProps[TechnologyObject]

	val prop: TechnologyObjectProps = TechnologyObjectProps()

	_registerPrefix("TO")
}
