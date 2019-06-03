package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait BusinessInternalBehaviorElement
	extends Element

trait BusinessInternalBehaviorElementRelationships[T <: BusinessInternalBehaviorElement]
	extends ElementRelationships[T] {
	def aggregates(dst: BusinessInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: BusinessInternalBehaviorElement): T = tt._rel.isComposedOf(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: BusinessPassiveStructureElement): T = tt._rel.accesses(dst)

	def realizes(dst: BusinessServiceElement): T = tt._rel.realizes(dst)
}
