package org.opengroup.archimate.relationships.other

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.OtherRelationship

case class Junction(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends OtherRelationship {
	override def reverse = Junction(dst, src, direct = false)
}
