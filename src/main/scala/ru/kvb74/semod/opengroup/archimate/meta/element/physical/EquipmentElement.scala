package ru.kvb74.semod.opengroup.archimate.meta.element.physical

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{NodeElement, NodeElementRelationships}

trait EquipmentElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

case object EquipmentElement
	extends ElementName

trait EquipmentElementRelationships[T <: EquipmentElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {

	def specializationOf(dst: NodeElement): T = tt._rel.specializationOf(dst)

	def assignedTo(dst: MaterialElement): T = tt._rel.assignedTo(dst)

	_register(EquipmentElement,
		JR.specializationOf(NodeElement),
		JR.assignedTo(MaterialElement)
	)

}

