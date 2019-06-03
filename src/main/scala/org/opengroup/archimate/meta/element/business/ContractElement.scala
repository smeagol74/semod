package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ContractElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessPassiveStructureElement


trait ContractElementRelationships[T <: ContractElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]