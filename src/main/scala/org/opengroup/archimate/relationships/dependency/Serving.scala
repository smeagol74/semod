package org.opengroup.archimate.relationships.dependency

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.DependencyRelationship

case class Serving(
	src: Element,
	dst: Element,
	direct: Boolean = true
)  extends DependencyRelationship {
	override def reverse = Serving(dst, src, direct = false)
}
