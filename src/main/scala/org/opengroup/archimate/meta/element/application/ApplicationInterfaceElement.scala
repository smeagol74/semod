package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ApplicationInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait ApplicationInterfaceElementRelationships[T <: ApplicationInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def assignedTo(dst: ApplicationServiceElement): T = tt._rel.assignedTo(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

}