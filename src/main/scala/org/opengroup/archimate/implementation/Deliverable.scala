package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{DeliverableElement, DeliverableElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class Deliverable(
	name: String,
	desc: String = ""
) extends Implementation
	with DeliverableElement {

	case class DeliverableRelationships(
		private[archimate] implicit val tt: Deliverable = Deliverable.this
	) extends DeliverableElementRelationships[Deliverable]

	val rel: DeliverableRelationships = DeliverableRelationships()

}
