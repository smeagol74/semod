package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.application.ApplicationInternalBehaviorElement
import org.opengroup.archimate.meta.element.business.BusinessInternalBehaviorElement
import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}
import org.opengroup.archimate.relationship.dependency.AccessMode

trait TechnologyInternalBehaviorElement
	extends Element

case object TechnologyInternalBehaviorElement
	extends ElementName

trait TechnologyInternalBehaviorElementRelationships[T <: TechnologyInternalBehaviorElement]
	extends ElementRelationships[T] {

	def realizes(dst: TechnologyServiceElement): T = tt._rel.aggregates(dst)

	def aggregates(dst: TechnologyInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: TechnologyInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def accesses(dst: TechnologyObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def realizes(dst: BusinessInternalBehaviorElement): T = tt._rel.realizes(dst)

	def realizes(dst: ApplicationInternalBehaviorElement): T = tt._rel.realizes(dst)

	_register(TechnologyInternalBehaviorElement,
		JR.realizes(TechnologyServiceElement),
		JR.aggregates(TechnologyInternalBehaviorElement),
		JR.composedOf(TechnologyInternalBehaviorElement),
		JR.accesses(TechnologyObjectElement),
		JR.triggers(TechnologyInternalBehaviorElement),
		JR.flowsTo(TechnologyInternalBehaviorElement),
		JR.triggers(TechnologyEventElement),
		JR.flowsTo(TechnologyEventElement),
		JR.realizes(BusinessInternalBehaviorElement),
		JR.realizes(ApplicationInternalBehaviorElement),
	)
}
