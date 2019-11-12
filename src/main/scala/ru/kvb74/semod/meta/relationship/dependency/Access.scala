package ru.kvb74.semod.meta.relationship.dependency

import ru.kvb74.semod.meta.{DirectionHint, Element}

object AccessMode extends Enumeration {
	val NONE,
	READ,
	WRITE,
	READ_WRITE = Value
}

case class Access(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
	mode: AccessMode.Value,
) extends DependencyRelationship {
	_registerPrefix("RA")
}
