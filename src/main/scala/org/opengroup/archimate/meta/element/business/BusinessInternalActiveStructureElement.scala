package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait BusinessInternalActiveStructureElement
	extends Element

trait BusinessInternalActiveStructureElementRelationships[T <: BusinessInternalActiveStructureElement]
	extends ElementRelationships[T] {
	def isComposedOf(dst: BusinessInterfaceElement): T = tt._rel.isComposedOf(dst)

	def assignedTo(dst: BusinessEventElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: BusinessInternalBehaviorElement): T = tt._rel.assignedTo(dst)
}