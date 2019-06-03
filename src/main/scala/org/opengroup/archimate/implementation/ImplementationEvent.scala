package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{ImplementationEventElement, ImplementationEventElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class ImplementationEvent(
	name: String,
	desc: String = ""
) extends Implementation
	with ImplementationEventElement {

	object rel extends ImplementationEventElementRelationships[ImplementationEvent] {
		private[archimate] implicit val tt: ImplementationEvent = ImplementationEvent.this
	}

}
