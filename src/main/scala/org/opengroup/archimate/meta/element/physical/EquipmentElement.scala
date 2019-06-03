package org.opengroup.archimate.meta.element.physical

import org.opengroup.archimate.meta.element.technology.{NodeElement, NodeElementRelationships}
import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait EquipmentElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

trait EquipmentElementRelationships[T <: EquipmentElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {

	def isSpecializationOf(dst: NodeElement): T = tt._rel.isSpecializationOf(dst)

	def assignedTo(dst: MaterialElement): T = tt._rel.assignedTo(dst)
}

