package ru.kvb74.semod.opengroup.archimate.relationship.dependency

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.DependencyRelationship

case class Influence(
	src: Element,
	dst: Element,
	label: String = "",
) extends DependencyRelationship
