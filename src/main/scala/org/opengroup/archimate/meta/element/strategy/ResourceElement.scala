package org.opengroup.archimate.meta.element.strategy

import org.opengroup.archimate.meta.element._

trait ResourceElement
	extends StructureElement
		with StrategyCoreStructureBehaviorElement

case object ResourceElement
	extends ElementName

trait ResourceElementRelationships[T <: ResourceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def assignedTo(dst: CapabilityElement): T = tt._rel.assignedTo(dst)

	_register(ResourceElement,
		JR.assignedTo(CapabilityElement)
	)

}
