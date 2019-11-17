package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.Origin
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{ImplementationEventElement, WorkPackageElement}

trait BusinessRoleElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalActiveStructureElement

case object BusinessRoleElement
	extends ElementName

trait BusinessRoleElementProps[T <: BusinessRoleElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with BusinessInternalActiveStructureElementProps[T]

trait BusinessRoleElementRelationships[T <: BusinessRoleElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalActiveStructureElementRelationships[T] {

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def assignedTo(dst: ImplementationEventElement): T = tt._rel.assignedTo(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def assignedTo(dst: WorkPackageElement): T = tt._rel.assignedTo(dst)

	_register(BusinessRoleElement,
		RR.assignedTo(ImplementationEventElement),
		RR.assignedTo(WorkPackageElement),
	)

}