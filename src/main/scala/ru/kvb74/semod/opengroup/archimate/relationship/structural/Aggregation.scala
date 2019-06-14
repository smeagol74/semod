package ru.kvb74.semod.opengroup.archimate.relationship.structural

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.{DirectionHint, StructuralRelationship}

case class Aggregation(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value
) extends StructuralRelationship
