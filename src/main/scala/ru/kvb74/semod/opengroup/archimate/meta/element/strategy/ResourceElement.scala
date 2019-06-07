package ru.kvb74.semod.opengroup.archimate.meta.element.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element._

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
