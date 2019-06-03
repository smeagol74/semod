package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ApplicationCollaborationElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait ApplicationCollaborationElementRelationships[T <: ApplicationCollaborationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def isComposedOf(dst: ApplicationInterfaceElement): T = tt._rel.isComposedOf(dst)

	def assignedTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: ApplicationEventElement): T = tt._rel.assignedTo(dst)

	def realizes(dst: ApplicationComponentElement): T = tt._rel.realizes(dst)

	def aggregates(dst: ApplicationComponentElement): T = tt._rel.aggregates(dst)

	def isSpecializationOf(dst: ApplicationComponentElement): T = tt._rel.isSpecializationOf(dst)
}