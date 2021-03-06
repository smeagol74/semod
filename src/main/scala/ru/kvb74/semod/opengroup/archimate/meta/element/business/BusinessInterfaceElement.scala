package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.application.ApplicationComponentElement
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.NodeElement

trait BusinessInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object BusinessInterfaceElement
	extends ElementName

trait BusinessInterfaceElementProps[T <: BusinessInterfaceElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

trait BusinessInterfaceElementRelationships[T <: BusinessInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def assignedTo(dst: BusinessServiceElement): T = tt._rel.assignedTo(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	_register(BusinessInterfaceElement,
		RR.serves(BusinessInternalActiveStructureElement),
		RR.assignedTo(BusinessServiceElement),
		RR.serves(ApplicationComponentElement),
		RR.serves(NodeElement),
	)

}
