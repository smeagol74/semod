package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessActorElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalActiveStructureElement

case object BusinessActorElement
	extends ElementName

trait BusinessActorElementProps[T <: BusinessActorElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with BusinessInternalActiveStructureElementProps[T]

trait BusinessActorElementRelationships[T <: BusinessActorElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalActiveStructureElementRelationships[T] {

	def assignedTo(dst: BusinessRoleElement): T = tt._rel.assignedTo(dst)

	_register(BusinessActorElement,
		RR.assignedTo(BusinessRoleElement)
	)

}