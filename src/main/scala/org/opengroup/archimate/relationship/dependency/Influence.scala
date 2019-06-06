package org.opengroup.archimate.relationship.dependency

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.DependencyRelationship

case class Influence(
	src: Element,
	dst: Element,
	label: String = "",
	direct: Boolean = true
) extends DependencyRelationship {
	override def reverse = Influence(dst, src, label, direct = false)
}
