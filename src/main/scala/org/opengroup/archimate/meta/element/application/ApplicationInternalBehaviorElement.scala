package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait ApplicationInternalBehaviorElement
	extends Element

trait ApplicationInternalBehaviorElementRelationships[T <: ApplicationInternalBehaviorElement]
	extends ElementRelationships[T] {
	def aggregates(dst: ApplicationInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: ApplicationInternalBehaviorElement): T = tt._rel.isComposedOf(dst)

	def realizes(dst: ApplicationServiceElement): T = tt._rel.realizes(dst)

	def accesses(dst: DataObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: ApplicationEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationEventElement): T = tt._rel.flowsTo(dst)
}
