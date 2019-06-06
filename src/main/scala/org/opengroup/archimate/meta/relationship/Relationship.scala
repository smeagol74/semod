package org.opengroup.archimate.meta.relationship

import org.opengroup.archimate.meta.element.Element

trait Relationship {
	val src: Element
	val dst: Element
	val direct: Boolean

	def reverse: Relationship = this
}
