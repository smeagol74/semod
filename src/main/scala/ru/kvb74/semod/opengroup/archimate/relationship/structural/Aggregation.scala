package ru.kvb74.semod.opengroup.archimate.relationship.structural

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.StructuralRelationship

case class Aggregation(
	src: Element,
	dst: Element,
) extends StructuralRelationship
