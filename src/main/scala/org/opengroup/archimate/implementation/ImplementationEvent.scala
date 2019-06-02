package org.opengroup.archimate.implementation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{Element, ElementRelationships}
import org.opengroup.archimate.layer.Implementation

case class ImplementationEvent(
	name: String,
	desc: String = ""
) extends Implementation
	with Element {
	val id: String = IdGenerator.implementation.implementationEvent

	object rel extends ElementRelationships[ImplementationEvent] {
		private[archimate] implicit val tt: ImplementationEvent = ImplementationEvent.this
	}

}
