package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait TechnologyInternalBehaviorElement extends Element

trait TechnologyInternalBehaviorElementRelationships[T <: TechnologyInternalBehaviorElement]
	extends ElementRelationships[T] {
	def realizes(dst: TechnologyServiceElement): T = tt._rel.aggregates(dst)

	def aggregates(dst: TechnologyInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: TechnologyInternalBehaviorElement): T = tt._rel.isComposedOf(dst)

	def accesses(dst: TechnologyObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement): T = tt._rel.flowsTo(dst)
}
