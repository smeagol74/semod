package org.opengroup.archimate.implementation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{Element, ElementRelationships}
import org.opengroup.archimate.layer.Implementation

case class Gap(
	name: String,
	desc: String = ""
) extends Implementation
	with Element {
	val id: String = IdGenerator.implementation.gap

	object rel extends ElementRelationships[Gap] {
		private[archimate] implicit val tt: Gap = Gap.this
	}

}
