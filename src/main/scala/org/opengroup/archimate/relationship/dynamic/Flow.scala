package org.opengroup.archimate.relationship.dynamic

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.DynamicRelationship

case class Flow(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends DynamicRelationship {
	override def reverse = Flow(dst, src, direct = false)
}
