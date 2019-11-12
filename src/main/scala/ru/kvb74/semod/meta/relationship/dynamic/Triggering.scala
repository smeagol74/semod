package ru.kvb74.semod.meta.relationship.dynamic

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class Triggering(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
) extends DynamicRelationship {
	_registerPrefix("RT")
}
