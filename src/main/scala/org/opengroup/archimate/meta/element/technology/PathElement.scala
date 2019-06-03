package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait PathElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait PathElementRelationships[T <: PathElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def associatedWith(dst: NodeElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: NodeElement): T = tt._rel.aggregates(dst)
}
