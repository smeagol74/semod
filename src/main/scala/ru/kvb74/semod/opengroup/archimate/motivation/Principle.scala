package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{PrincipleElement, PrincipleElementProps, PrincipleElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Principle(
	name: String
) extends MotivationLayer
	with PrincipleElement {

	case class PrincipleRelationships(
		override private[semod] implicit val tt: Principle = Principle.this
	) extends PrincipleElementRelationships[Principle]

	val rel: PrincipleRelationships = PrincipleRelationships()

	case class PrincipleProps(
		override private[semod] implicit val tt: Principle = Principle.this
	) extends PrincipleElementProps[Principle]

	val prop: PrincipleProps = PrincipleProps()

	_registerPrefix("MP")
}
