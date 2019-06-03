package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessActorElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalActiveStructureElement

trait BusinessActorElementRelationships[T <: BusinessActorElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalActiveStructureElementRelationships[T] {
	def assignedTo(dst: BusinessRoleElement): T = tt._rel.assignedTo(dst)
}