package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.meta.AggregationElement
import ru.kvb74.semod.omg.essence.meta.element.{AreaElement, AreaElementProps, AreaElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Area(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
  with AggregationElement
	with AreaElement {

	case class AreaRelationships(
		override private[semod] implicit val tt: Area = Area.this
	) extends AreaElementRelationships[Area]

	val rel: AreaRelationships = AreaRelationships()

	case class AreaProps(
		override private[semod] implicit val tt: Area = Area.this
	) extends AreaElementProps[Area]

	val prop: AreaProps = AreaProps()

	_registerPrefix("EAr")

}

