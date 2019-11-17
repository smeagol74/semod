package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{WorkPackageElement, WorkPackageElementProps, WorkPackageElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class WorkPackage(
	name: String
) extends ImplementationLayer
	with WorkPackageElement {

	case class WorkPackageRelationships(
		override private[semod] implicit val tt: WorkPackage = WorkPackage.this
	) extends WorkPackageElementRelationships[WorkPackage]

	val rel: WorkPackageRelationships = WorkPackageRelationships()

	case class WorkPackageProps(
		override private[semod] implicit val tt: WorkPackage = WorkPackage.this
	) extends WorkPackageElementProps[WorkPackage]

	val prop: WorkPackageProps = WorkPackageProps()

	_registerPrefix("IWP")
}

