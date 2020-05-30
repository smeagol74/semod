package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{AlphaElement, AlphaElementProps, AlphaElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Alpha(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with AlphaElement {

	case class AlphaRelationships(
		override private[semod] implicit val tt: Alpha = Alpha.this
	) extends AlphaElementRelationships[Alpha]

	val rel: AlphaRelationships = AlphaRelationships()

	case class AlphaProps(
		override private[semod] implicit val tt: Alpha = Alpha.this
	) extends AlphaElementProps[Alpha]

	val prop: AlphaProps = AlphaProps()

	_registerPrefix("EAl")

}

