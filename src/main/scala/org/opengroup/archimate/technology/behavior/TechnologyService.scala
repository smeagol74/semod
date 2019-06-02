package org.opengroup.archimate.technology.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyInternalBehaviorElement, TechnologyNodeElement, TechnologyObjectElement}
import org.opengroup.archimate.technology.structure.active.{Device, SystemSoftware, TechnologyCollaboration}
import org.opengroup.archimate.technology.structure.passive.Artifact

case class TechnologyService(
	name: String,
	desc: String = ""
) extends Technology
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.technologyService

	object rel extends StrategyCoreStructureBehaviorElementRelationships[TechnologyService] {
		private[archimate] implicit val tt: TechnologyService = TechnologyService.this

		def triggers(dst: TechnologyService): TechnologyService = tt._rel.triggers(dst)

		def flowsTo(dst: TechnologyService): TechnologyService = tt._rel.flowsTo(dst)

		def triggers(dst: TechnologyEvent): TechnologyService = tt._rel.triggers(dst)

		def flowsTo(dst: TechnologyEvent): TechnologyService = tt._rel.flowsTo(dst)

		def accesses(dst: TechnologyObjectElement): TechnologyService = tt._rel.accesses(dst)

		def accesses(dst: Artifact): TechnologyService = tt._rel.accesses(dst)

		def serves(dst: TechnologyInternalBehaviorElement): TechnologyService = tt._rel.serves(dst)

		def serves(dst: TechnologyNodeElement): TechnologyService = tt._rel.serves(dst)

		def serves(dst: SystemSoftware): TechnologyService = tt._rel.serves(dst)

		def serves(dst: Device): TechnologyService = tt._rel.serves(dst)

		def serves(dst: TechnologyCollaboration): TechnologyService = tt._rel.serves(dst)
	}

}
