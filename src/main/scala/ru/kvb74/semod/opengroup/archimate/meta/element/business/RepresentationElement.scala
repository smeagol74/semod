package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait RepresentationElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessPassiveStructureElement

case object RepresentationElement
	extends ElementName

trait RepresentationElementRelationships[T <: RepresentationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: BusinessObjectElement): T = tt._rel.realizes(dst)

	def realizes(dst: ContractElement): T = tt._rel.realizes(dst)

	_register(RepresentationElement,
		JR.realizes(BusinessObjectElement),
		JR.realizes(ContractElement),
	)
}
