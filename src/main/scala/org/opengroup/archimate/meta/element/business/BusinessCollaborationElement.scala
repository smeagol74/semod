package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessCollaborationElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalActiveStructureElement

trait BusinessCollaborationElementRelationships[T <: BusinessCollaborationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalActiveStructureElementRelationships[T] {
	def aggregates(dst: BusinessInternalActiveStructureElement): T = tt._rel.aggregates(dst)
}
