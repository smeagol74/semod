package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyCollaborationElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

trait TechnologyCollaborationElementRelationships[T <: TechnologyCollaborationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {
	def aggregates(dst: NodeElement): T = tt._rel.aggregates(dst)
}
