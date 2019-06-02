package org.opengroup.archimate.technology.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyObjectElement}
import org.opengroup.archimate.technology.structure.active.SystemSoftware

case class Artifact(
	name: String,
	desc: String = ""
) extends Technology
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyObjectElement {
	val id: String = IdGenerator.technology.artifact

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Artifact] {
		private[archimate] implicit val tt: Artifact = Artifact.this

		def isSpecializationOf(dst: TechnologyObjectElement): Artifact = tt._rel.isSpecializationOf(dst)

		def realizes(dst: SystemSoftware): Artifact = tt._rel.realizes(dst)
	}

}
