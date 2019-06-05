package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{WorkPackageElement, WorkPackageElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class WorkPackage(
	name: String,
	desc: String = ""
) extends Implementation
	with WorkPackageElement {

	case class WorkPackageRelationships(
		override private[archimate] implicit val tt: WorkPackage = WorkPackage.this
	) extends WorkPackageElementRelationships[WorkPackage]

	val rel: WorkPackageRelationships = WorkPackageRelationships()
}

