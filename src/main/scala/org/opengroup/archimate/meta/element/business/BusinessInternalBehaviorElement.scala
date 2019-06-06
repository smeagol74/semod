package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}
import org.opengroup.archimate.meta.relationship.Junction
import org.opengroup.archimate.relationship.dependency.AccessMode

trait BusinessInternalBehaviorElement
	extends Element

case object BusinessInternalBehaviorElement
	extends ElementName

trait BusinessInternalBehaviorElementRelationships[T <: BusinessInternalBehaviorElement]
	extends ElementRelationships[T] {

	def aggregates(dst: BusinessInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: BusinessInternalBehaviorElement): T = tt._rel.composedOf(dst)

	def triggers(dst: BusinessEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: BusinessInternalBehaviorElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: BusinessPassiveStructureElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def realizes(dst: BusinessServiceElement): T = tt._rel.realizes(dst)

	_register(BusinessInternalBehaviorElement,
		JR.aggregates(BusinessInternalBehaviorElement),
		JR.composedOf(BusinessInternalBehaviorElement),
		JR.triggers(BusinessEventElement),
		JR.flowsTo(BusinessEventElement),
		JR.triggers(BusinessInternalBehaviorElement),
		JR.flowsTo(BusinessInternalBehaviorElement),
		JR.accesses(BusinessPassiveStructureElement),
		JR.realizes(BusinessServiceElement),
	)
}
