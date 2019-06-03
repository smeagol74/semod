package org.opengroup.archimate.relationship.structural

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.StructuralRelationship

case class Aggregation(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends StructuralRelationship {
	override def reverse = Aggregation(dst, src, direct = false)
}
