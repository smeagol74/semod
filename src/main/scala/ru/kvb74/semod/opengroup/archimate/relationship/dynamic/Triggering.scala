package ru.kvb74.semod.opengroup.archimate.relationship.dynamic

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.DynamicRelationship

case class Triggering(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends DynamicRelationship {
	override def reverse = Triggering(dst, src, direct = false)
}
