package org.opengroup.archimate.meta.element.motivation

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait MotivationElement
	extends Element

trait MotivationElementRelationships[T <: Element] extends ElementRelationships[T] {
	def influences(dst: MotivationElement, label: String): T = tt._rel.influences(dst, label)
}