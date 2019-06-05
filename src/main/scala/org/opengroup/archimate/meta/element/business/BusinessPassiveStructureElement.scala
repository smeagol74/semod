package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait BusinessPassiveStructureElement
	extends Element

case object BusinessPassiveStructureElement
	extends ElementName

trait BusinessPassiveStructureElementRelationships[T <: BusinessPassiveStructureElement]
	extends ElementRelationships[T] {

	_register(BusinessPassiveStructureElement)

}