package ru.kvb74.semod.opengroup.archimate.meta.element.strategy

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait ResourceElement
	extends StructureElement
		with StrategyCoreStructureBehaviorElement

case object ResourceElement
	extends ElementName

trait ResourceElementProps[T <: ResourceElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

trait ResourceElementRelationships[T <: ResourceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def assignedTo(dst: CapabilityElement): T = tt._rel.assignedTo(dst)

	_register(ResourceElement,
		RR.assignedTo(CapabilityElement)
	)

}
