package ru.kvb74.semod.opengroup.archimate.relationship.dependency

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.DependencyRelationship

case class Serving(
	src: Element,
	dst: Element,
	direct: Boolean = true
)  extends DependencyRelationship {
	override def reverse = Serving(dst, src, direct = false)
}
