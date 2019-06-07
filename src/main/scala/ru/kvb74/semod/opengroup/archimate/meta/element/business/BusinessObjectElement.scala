package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessPassiveStructureElement

case object BusinessObjectElement
	extends ElementName

trait BusinessObjectElementRelationships[T <: BusinessObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessPassiveStructureElementRelationships[T] {

	_register(BusinessObjectElement)
}
