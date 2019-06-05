package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._

trait ContractElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessPassiveStructureElement
		with BusinessObjectElement

case object ContractElement
	extends ElementName

trait ContractElementRelationships[T <: ContractElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessPassiveStructureElementRelationships[T]
		with BusinessObjectElementRelationships[T] {

	def specializationOf(dst: BusinessObjectElement): T = tt._rel.specializationOf(dst)

	_register(ContractElement,
		JR.specializationOf(BusinessObjectElement)
	)

}