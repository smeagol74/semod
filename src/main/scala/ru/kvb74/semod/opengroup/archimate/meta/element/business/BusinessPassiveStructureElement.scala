package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementRelationships}

trait BusinessPassiveStructureElement
	extends ArchimateElement

case object BusinessPassiveStructureElement
	extends ElementName

trait BusinessPassiveStructureElementRelationships[T <: BusinessPassiveStructureElement]
	extends ArchimateElementRelationships[T] {

	_register(BusinessPassiveStructureElement)

}