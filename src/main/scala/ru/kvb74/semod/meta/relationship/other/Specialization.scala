package ru.kvb74.semod.meta.relationship.other

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class Specialization(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value
) extends OtherRelationship {
	_registerPrefix("RSp")
}
