package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ApplicationComponentElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait ApplicationComponentElementRelationships[T <: ApplicationComponentElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def isComposedOf(dst: ApplicationInterfaceElement): T = tt._rel.isComposedOf(dst)

	def assignedTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: ApplicationEventElement): T = tt._rel.assignedTo(dst)

	def realizes(dst: ApplicationComponentElement): T = tt._rel.realizes(dst)
}
