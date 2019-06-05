package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}

trait TechnologyInternalBehaviorElement
	extends Element

case object TechnologyInternalBehaviorElement
	extends ElementName

trait TechnologyInternalBehaviorElementRelationships[T <: TechnologyInternalBehaviorElement]
	extends ElementRelationships[T] {

	def realizes(dst: TechnologyServiceElement): T = tt._rel.aggregates(dst)

	def aggregates(dst: TechnologyInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: TechnologyInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def accesses(dst: TechnologyObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement): T = tt._rel.flowsTo(dst)

	_register(TechnologyInternalBehaviorElement,
		JR.realizes(TechnologyServiceElement),
		JR.aggregates(TechnologyInternalBehaviorElement),
		JR.composedOf(TechnologyInternalBehaviorElement),
		JR.accesses(TechnologyObjectElement),
		JR.triggers(TechnologyInternalBehaviorElement),
		JR.flowsTo(TechnologyInternalBehaviorElement),
		JR.triggers(TechnologyEventElement),
		JR.flowsTo(TechnologyEventElement),
	)
}
