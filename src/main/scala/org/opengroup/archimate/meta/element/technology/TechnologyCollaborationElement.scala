package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait TechnologyCollaborationElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

case object TechnologyCollaborationElement
	extends ElementName

trait TechnologyCollaborationElementRelationships[T <: TechnologyCollaborationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {

	def aggregates(dst: NodeElement): T = tt._rel.aggregates(dst)

	_register(TechnologyCollaborationElement,
		JR.aggregates(NodeElement)
	)
}
