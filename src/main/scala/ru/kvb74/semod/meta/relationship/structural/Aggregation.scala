package ru.kvb74.semod.meta.relationship.structural

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class Aggregation(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value
) extends StructuralRelationship {
	_registerPrefix("RAg")
}
