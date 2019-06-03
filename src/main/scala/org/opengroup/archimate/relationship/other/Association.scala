package org.opengroup.archimate.relationship.other

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.OtherRelationship

case class Association(
	src: Element,
	dst: Element,
	direct: Boolean = true
)  extends OtherRelationship {
	override def reverse = Association(dst, src, direct = false)
}
