package org.opengroup.archimate.relationship.dependency

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.DependencyRelationship

object AccessMode extends Enumeration {
	val NONE,
	READ,
	WRITE,
	READ_WRITE = Value
}

case class Access(
	src: Element,
	dst: Element,
	mode: AccessMode.Value,
	direct: Boolean = true
) extends DependencyRelationship {
	override def reverse = Access(dst, src, mode, direct = false)
}
