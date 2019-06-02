package org.opengroup.archimate.implementation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{Element, ElementRelationships}
import org.opengroup.archimate.layer.Implementation

case class WorkPackage(
	name: String,
	desc: String = ""
) extends Implementation
	with Element {
	val id: String = IdGenerator.implementation.workPackage

	object rel extends ElementRelationships[WorkPackage] {
		private[archimate] implicit val tt: WorkPackage = WorkPackage.this
	}

}
