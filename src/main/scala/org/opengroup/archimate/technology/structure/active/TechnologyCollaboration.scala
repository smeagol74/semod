package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyNodeElement, TechnologyNodeElementRelationships}

case class TechnologyCollaboration(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyNodeElement {
	val id: String = IdGenerator.technology.technologyCollaboration

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyCollaboration]
		with TechnologyNodeElementRelationships[TechnologyCollaboration] {
		private[archimate] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this

		def aggregates(dst: TechnologyNodeElement): TechnologyCollaboration = tt._rel.aggregates(dst)
	}

}
