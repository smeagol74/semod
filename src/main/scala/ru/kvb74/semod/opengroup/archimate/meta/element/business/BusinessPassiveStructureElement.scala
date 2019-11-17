package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementProps, ArchimateElementRelationships}

trait BusinessPassiveStructureElement
	extends ArchimateElement

case object BusinessPassiveStructureElement
	extends ElementName

trait BusinessPassiveStructureElementProps[T <: BusinessPassiveStructureElement]
	extends ArchimateElementProps[T]

trait BusinessPassiveStructureElementRelationships[T <: BusinessPassiveStructureElement]
	extends ArchimateElementRelationships[T] {

	_register(BusinessPassiveStructureElement)

}