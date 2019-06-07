package ru.kvb74.semod.opengroup.archimate.relationship.dynamic

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.DynamicRelationship

case class Flow(
	src: Element,
	dst: Element,
	label: String,
	direct: Boolean = true
) extends DynamicRelationship {
	override def reverse = Flow(dst, src, label, direct = false)
}
