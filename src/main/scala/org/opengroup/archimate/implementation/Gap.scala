package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{GapElement, GapElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class Gap(
	name: String,
	desc: String = ""
) extends Implementation
	with GapElement {

	object rel extends GapElementRelationships[Gap] {
		private[archimate] implicit val tt: Gap = Gap.this
	}

}
