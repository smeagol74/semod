package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{AlphaStateElement, AlphaStateElementProps, AlphaStateElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class AlphaState(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with AlphaStateElement {

	case class AlphaStateRelationships(
		override private[semod] implicit val tt: AlphaState = AlphaState.this
	) extends AlphaStateElementRelationships[AlphaState]

	val rel: AlphaStateRelationships = AlphaStateRelationships()

	case class AlphaStateProps(
		override private[semod] implicit val tt: AlphaState = AlphaState.this
	) extends AlphaStateElementProps[AlphaState]

	val prop: AlphaStateProps = AlphaStateProps()

	_registerPrefix("EAlS")

}

