package org.opengroup.archimate.relationships.structural

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.StructuralRelationship

case class Composition(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends StructuralRelationship {
	override def reverse = Composition(dst, src, direct = false)
}
