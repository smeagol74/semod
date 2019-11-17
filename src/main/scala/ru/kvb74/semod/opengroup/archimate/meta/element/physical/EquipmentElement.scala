package ru.kvb74.semod.opengroup.archimate.meta.element.physical

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.{MissedInSpec, Origin}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{NodeElement, NodeElementProps, NodeElementRelationships}

trait EquipmentElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

case object EquipmentElement
	extends ElementName

trait EquipmentElementProps[T <: EquipmentElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with NodeElementProps[T]

trait EquipmentElementRelationships[T <: EquipmentElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {

	def specializationOf(dst: NodeElement): T = tt._rel.specializationOf(dst)

	def assignedTo(dst: MaterialElement): T = tt._rel.assignedTo(dst)

	@MissedInSpec
	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946113")
	def accesses(dst: MaterialElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	_register(EquipmentElement,
		RR.specializationOf(NodeElement),
		RR.assignedTo(MaterialElement),
		RR.accesses(MaterialElement)
	)

}

