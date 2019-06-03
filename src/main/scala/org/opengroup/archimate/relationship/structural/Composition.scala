package org.opengroup.archimate.relationship.structural

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.StructuralRelationship

case class Composition(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends StructuralRelationship {
	override def reverse = Composition(dst, src, direct = false)
}
