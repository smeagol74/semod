package org.opengroup.archimate.relationships.dynamic

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.DynamicRelationship

case class Flow(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends DynamicRelationship {
	override def reverse = Flow(dst, src, direct = false)
}
