package org.opengroup.archimate.relationship.structural

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.StructuralRelationship

case class Realization(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends StructuralRelationship {
	override def reverse = Realization(dst, src, direct = false)
}
