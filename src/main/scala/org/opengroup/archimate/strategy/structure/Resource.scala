package org.opengroup.archimate.strategy.structure

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships, StructureElement}
import org.opengroup.archimate.layer.Strategy
import org.opengroup.archimate.strategy.behavior.Capability

case class Resource(
	name: String,
	desc: String = ""
) extends Strategy with StructureElement with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.strategy.resource

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Resource] {

		implicit val tt: Resource = Resource.this

		def assignedTo(dst: Capability): Resource = tt._rel.assignedTo(dst)
	}

}
