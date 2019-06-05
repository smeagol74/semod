package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{GapElement, GapElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class Gap(
	name: String,
	desc: String = ""
) extends Implementation
	with GapElement {

	case class GapRelationships(
		override private[archimate] implicit val tt: Gap = Gap.this
	) extends GapElementRelationships[Gap]

	val rel: GapRelationships = GapRelationships()

}
