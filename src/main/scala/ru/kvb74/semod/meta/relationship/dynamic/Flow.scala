package ru.kvb74.semod.meta.relationship.dynamic

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class Flow(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
	label: String,
) extends DynamicRelationship {
	_registerPrefix("RF")
}
