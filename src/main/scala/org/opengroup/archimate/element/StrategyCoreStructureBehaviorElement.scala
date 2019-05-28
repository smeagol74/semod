package org.opengroup.archimate.element

import org.opengroup.archimate.motivation.{Meaning, Requirement, Value}

/**
	* Structure Element / Behavior Element
	* (Strategy & Core)
	*/
trait StrategyCoreStructureBehaviorElement extends Element

trait StrategyCoreStructureBehaviorElementRelationships[T <: Element] extends ElementRelationships[T] {

	def influences(dst: Requirement, label: String): T = tt._rel.influences(dst, label)

	def realizes(dst: Requirement): T = tt._rel.realizes(dst)

	def associatedWith(dst: Value): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: Meaning): T = tt._rel.associatedWith(dst)
}