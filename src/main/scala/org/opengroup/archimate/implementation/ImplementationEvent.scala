package org.opengroup.archimate.implementation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.Element
import org.opengroup.archimate.layer.Implementation

case class ImplementationEvent(
	name: String,
	desc: String = ""
) extends Implementation
	with Element {
	val id: String = IdGenerator.implementation.implementationEvent

}
