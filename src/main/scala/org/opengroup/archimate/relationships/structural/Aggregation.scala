package org.opengroup.archimate.relationships.structural

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.StructuralRelationship

case class Aggregation(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends StructuralRelationship {
	override def reverse = Aggregation(dst, src, direct = false)
}
