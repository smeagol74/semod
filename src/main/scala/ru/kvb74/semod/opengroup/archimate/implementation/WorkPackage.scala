package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{WorkPackageElement, WorkPackageElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Implementation

case class WorkPackage(
	name: String,
	desc: String = ""
) extends Implementation
	with WorkPackageElement {

	case class WorkPackageRelationships(
		override private[semod] implicit val tt: WorkPackage = WorkPackage.this
	) extends WorkPackageElementRelationships[WorkPackage]

	val rel: WorkPackageRelationships = WorkPackageRelationships()

	_registerPrefix("IWP")
}

