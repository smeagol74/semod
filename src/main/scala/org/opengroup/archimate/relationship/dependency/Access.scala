package org.opengroup.archimate.relationship.dependency

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.DependencyRelationship

case class Access(
	src: Element,
	dst: Element,
	direct: Boolean = true
) extends DependencyRelationship {
	override def reverse = Access(dst, src, direct = false)
}
