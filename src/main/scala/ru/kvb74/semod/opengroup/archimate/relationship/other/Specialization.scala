package ru.kvb74.semod.opengroup.archimate.relationship.other

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.OtherRelationship

case class Specialization(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends OtherRelationship {
	override def reverse = Specialization(dst, src, direct = false)
}
