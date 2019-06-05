package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait PathElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object PathElement
	extends ElementName

trait PathElementRelationships[T <: PathElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def associatedWith(dst: NodeElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: NodeElement): T = tt._rel.aggregates(dst)

	_register(PathElement,
		JR.associatedWith(NodeElement),
		JR.aggregates(NodeElement),
	)
}
