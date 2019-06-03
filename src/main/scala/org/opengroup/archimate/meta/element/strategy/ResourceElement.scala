package org.opengroup.archimate.meta.element.strategy

import org.opengroup.archimate.meta.element.{StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships, StructureElement}

trait ResourceElement
	extends StructureElement
		with StrategyCoreStructureBehaviorElement

trait ResourceElementRelationships[T <: ResourceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def assignedTo(dst: CapabilityElement): T = tt._rel.assignedTo(dst)
}
