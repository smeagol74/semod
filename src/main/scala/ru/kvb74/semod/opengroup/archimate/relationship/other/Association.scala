package ru.kvb74.semod.opengroup.archimate.relationship.other

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.{DirectionHint, OtherRelationship}

case class Association(
	src: Element,
	dst: Element,
	dir: DirectionHint.Value,
	label: String,
) extends OtherRelationship
