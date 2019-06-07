package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessCollaborationElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalActiveStructureElement

case object BusinessCollaborationElement
	extends ElementName

trait BusinessCollaborationElementRelationships[T <: BusinessCollaborationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalActiveStructureElementRelationships[T] {

	def aggregates(dst: BusinessInternalActiveStructureElement): T = tt._rel.aggregates(dst)

	_register(BusinessCollaborationElement,
		JR.aggregates(BusinessInternalActiveStructureElement)
	)

}
