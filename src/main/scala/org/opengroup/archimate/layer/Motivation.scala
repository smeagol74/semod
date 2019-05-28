package org.opengroup.archimate.layer

import org.opengroup.archimate.element.{Element, ElementRelationships}

trait Motivation extends Layer {
	override def _puml = "Motivation"
}

trait MotivationElement extends Element

trait MotivationElementRelationships[T <: Element] extends ElementRelationships[T] {
	def influences(dst: MotivationElement, label: String): T = tt._rel.influences(dst, label)
}