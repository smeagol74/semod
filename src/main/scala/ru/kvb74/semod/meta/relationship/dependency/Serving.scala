package ru.kvb74.semod.meta.relationship.dependency

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class Serving(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
) extends DependencyRelationship {
	_registerPrefix("RS")
}