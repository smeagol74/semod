package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{WorkPackageElement, WorkPackageElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class WorkPackage(
	name: String,
	desc: String = ""
) extends Implementation
	with WorkPackageElement {

	object rel extends WorkPackageElementRelationships[WorkPackage] {
		private[archimate] implicit val tt: WorkPackage = WorkPackage.this
	}

}
