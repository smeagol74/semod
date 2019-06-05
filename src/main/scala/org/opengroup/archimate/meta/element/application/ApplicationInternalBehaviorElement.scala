package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}
import org.opengroup.archimate.meta.relationship.Junction

trait ApplicationInternalBehaviorElement
	extends Element

case object ApplicationInternalBehaviorElement
	extends ElementName

trait ApplicationInternalBehaviorElementRelationships[T <: ApplicationInternalBehaviorElement]
	extends ElementRelationships[T] {

	def aggregates(dst: ApplicationInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: ApplicationInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def realizes(dst: ApplicationServiceElement): T = tt._rel.realizes(dst)

	def accesses(dst: DataObjectElement): T = tt._rel.accesses(dst)

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: ApplicationEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationEventElement): T = tt._rel.flowsTo(dst)

	_register(ApplicationInternalBehaviorElement,
		JR.aggregates(ApplicationInternalBehaviorElement),
		JR.composedOf(ApplicationInternalBehaviorElement),
		JR.realizes(ApplicationServiceElement),
		JR.accesses(DataObjectElement),
		JR.triggers(ApplicationInternalBehaviorElement),
		JR.flowsTo(ApplicationInternalBehaviorElement),
		JR.triggers(ApplicationEventElement),
		JR.flowsTo(ApplicationEventElement),
	)
}
