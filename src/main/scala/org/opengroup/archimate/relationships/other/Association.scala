package org.opengroup.archimate.relationships.other

import org.opengroup.archimate.element.Element
import org.opengroup.archimate.relationships.OtherRelationship

case class Association(
	src: Element,
	dst: Element,
	direct: Boolean = true
)  extends OtherRelationship {
	override def reverse = Association(dst, src, direct = false)
}
