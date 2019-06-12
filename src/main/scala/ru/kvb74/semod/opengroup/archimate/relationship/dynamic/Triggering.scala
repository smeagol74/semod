package ru.kvb74.semod.opengroup.archimate.relationship.dynamic

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.DynamicRelationship

case class Triggering(
	src: Element,
	dst: Element,
) extends DynamicRelationship
