package ru.kvb74.semod.meta.relationship.other

import ru.kvb74.semod.meta.{DirectionHint, Element}

case class _Association(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
	label: String,
) extends OtherRelationship {
	_registerPrefix("RAs_")
}
