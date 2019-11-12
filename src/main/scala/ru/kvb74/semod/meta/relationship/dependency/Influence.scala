package ru.kvb74.semod.meta.relationship.dependency

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class Influence(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
	label: String = "",
) extends DependencyRelationship {
	_registerPrefix("RI")
}
