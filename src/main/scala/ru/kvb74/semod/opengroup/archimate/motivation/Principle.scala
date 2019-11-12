package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{PrincipleElement, PrincipleElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Principle(
	name: String,
	desc: String = ""
) extends Motivation
	with PrincipleElement {

	case class PrincipleRelationships(
		override private[semod] implicit val tt: Principle = Principle.this
	) extends PrincipleElementRelationships[Principle]

	val rel: PrincipleRelationships = PrincipleRelationships()

	_registerPrefix("MP")
}
