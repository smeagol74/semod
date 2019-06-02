package org.opengroup.archimate.layer

import org.opengroup.archimate.application.behavior.{ApplicationEvent, ApplicationService}
import org.opengroup.archimate.application.structure.passive.DataObject
import org.opengroup.archimate.element.{Element, ElementRelationships}

trait Application extends Layer {
	override def _puml = "Application"
}

trait ApplicationInternalBehaviorElement extends Element {

}

trait ApplicationInternalBehaviorElementRelationships[T <: Element] extends ElementRelationships[T] {
	def aggregates(dst: ApplicationInternalBehaviorElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: ApplicationInternalBehaviorElement): T = tt._rel.isComposedOf(dst)

	def realizes(dst: ApplicationService): T = tt._rel.realizes(dst)

	def accesses(dst: DataObject): T = tt._rel.accesses(dst)

	def triggers(dst: ApplicationInternalBehaviorElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: ApplicationEvent): T = tt._rel.triggers(dst)

	def flowsTo(dst: ApplicationEvent): T = tt._rel.flowsTo(dst)
}