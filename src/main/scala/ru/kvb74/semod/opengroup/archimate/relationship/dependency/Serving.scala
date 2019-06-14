package ru.kvb74.semod.opengroup.archimate.relationship.dependency

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.{DependencyRelationship, DirectionHint}

case class Serving(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
) extends DependencyRelationship