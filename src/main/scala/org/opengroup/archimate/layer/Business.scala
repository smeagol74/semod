package org.opengroup.archimate.layer

import org.opengroup.archimate.business.behavior.{BusinessEvent, BusinessService}
import org.opengroup.archimate.business.structure.active.BusinessInterface
import org.opengroup.archimate.element.{Element, ElementRelationships}

trait Business extends Layer {
	override def _puml = "Business"
}

trait BusinessInternalBehaviorElement extends Element

trait BusinessInternalBehaviorElementRelationships[T <: Element] extends ElementRelationships[T] {
	def aggregates(dst: BusinessInternalBehaviorElement): T = tt._rel.aggregates(dst)
	def isComposedOf(dst: BusinessInternalBehaviorElement): T = tt._rel.isComposedOf(dst)
	def triggers(dst: BusinessEvent): T = tt._rel.triggers(dst)
	def flowsTo(dst: BusinessEvent): T = tt._rel.flowsTo(dst)
	def triggers(dst: BusinessInternalBehaviorElement): T = tt._rel.triggers(dst)
	def flowsTo(dst: BusinessInternalBehaviorElement): T = tt._rel.flowsTo(dst)
	def accesses(dst: BusinessPassiveStructureElement): T = tt._rel.accesses(dst)
	def realizes(dst: BusinessService): T = tt._rel.realizes(dst)
}

trait BusinessInternalActiveStructureElement extends Element

trait BusinessInternalActiveStructureElementRelationships[T <: Element] extends ElementRelationships[T] {
	def isComposedOf(dst: BusinessInterface): T = tt._rel.isComposedOf(dst)
	def assignedTo(dst: BusinessEvent): T = tt._rel.assignedTo(dst)
	def assignedTo(dst: BusinessInternalBehaviorElement): T = tt._rel.assignedTo(dst)
}

trait BusinessPassiveStructureElement extends Element
