package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}

trait BusinessInternalActiveStructureElement
	extends Element

case object BusinessInternalActiveStructureElement
	extends ElementName

trait BusinessInternalActiveStructureElementRelationships[T <: BusinessInternalActiveStructureElement]
	extends ElementRelationships[T] {

	def composedOf(dst: BusinessInterfaceElement): T = tt._rel.composedOf(dst)

	def assignedTo(dst: BusinessEventElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: BusinessInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	_register(BusinessInternalActiveStructureElement,
		JR.composedOf(BusinessInterfaceElement),
		JR.assignedTo(BusinessEventElement),
		JR.assignedTo(BusinessInternalBehaviorElement)
	)
}