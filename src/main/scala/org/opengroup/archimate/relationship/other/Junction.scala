package org.opengroup.archimate.relationship.other

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.OtherRelationship

case class Junction(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends OtherRelationship {
	override def reverse = Junction(dst, src, direct = false)
}
