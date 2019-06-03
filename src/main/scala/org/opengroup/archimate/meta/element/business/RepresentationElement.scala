package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait RepresentationElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessPassiveStructureElement

trait RepresentationElementRelationships[T <: RepresentationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def realizes(dst: BusinessObjectElement): T = tt._rel.realizes(dst)

	def realizes(dst: ContractElement): T = tt._rel.realizes(dst)
}
