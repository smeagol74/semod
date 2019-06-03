package org.opengroup.archimate.relationship.dynamic

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.DynamicRelationship

case class Triggering(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends DynamicRelationship {
	override def reverse = Triggering(dst, src, direct = false)
}
