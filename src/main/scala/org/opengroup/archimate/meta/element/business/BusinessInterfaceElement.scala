package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait BusinessInterfaceElementRelationships[T <: BusinessInterfaceElement]
extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)
	def assignedTo(dst: BusinessServiceElement): T = tt._rel.assignedTo(dst)
}
