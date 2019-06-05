package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait NodeElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object NodeElement
	extends ElementName

trait NodeElementRelationships[T <: NodeElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: NodeElement): T = tt._rel.realizes(dst)

	def assignedTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: TechnologyEventElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: ArtifactElement): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: PathElement): T = tt._rel.associatedWith(dst)

	_register(NodeElement,
		JR.realizes(NodeElement),
		JR.assignedTo(TechnologyInternalBehaviorElement),
		JR.assignedTo(TechnologyEventElement),
		JR.assignedTo(ArtifactElement),
		JR.associatedWith(PathElement),
	)
}
