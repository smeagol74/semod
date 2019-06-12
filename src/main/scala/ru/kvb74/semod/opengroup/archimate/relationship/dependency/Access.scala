package ru.kvb74.semod.opengroup.archimate.relationship.dependency

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.DependencyRelationship

object AccessMode extends Enumeration {
	val NONE,
	READ,
	WRITE,
	READ_WRITE = Value
}

case class Access(
	src: Element,
	dst: Element,
	mode: AccessMode.Value,
) extends DependencyRelationship
