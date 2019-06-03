package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{DeliverableElement, DeliverableElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class Deliverable(
	name: String,
	desc: String = ""
) extends Implementation
	with DeliverableElement {

	object rel extends DeliverableElementRelationships[Deliverable] {
		private[archimate] implicit val tt: Deliverable = Deliverable.this
	}

}
