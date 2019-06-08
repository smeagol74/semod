package ru.kvb74.semod.opengroup.archimate.relationship.other

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.relationship.OtherRelationship

case class Association(
	src: Element,
	dst: Element,
	label: String,
	direct: Boolean = true
) extends OtherRelationship {
	override def reverse = Association(dst, src, label, direct = false)
}
