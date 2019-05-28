package org.opengroup.archimate.relationships.other

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.OtherRelationship

case class Specialization(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends OtherRelationship {
	override def reverse = Specialization(dst, src, direct = false)
}
