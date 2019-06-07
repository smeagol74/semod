package ru.kvb74.semod.opengroup.archimate.relationship.structural

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.StructuralRelationship

case class Realization(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends StructuralRelationship {
	override def reverse = Realization(dst, src, direct = false)
}
