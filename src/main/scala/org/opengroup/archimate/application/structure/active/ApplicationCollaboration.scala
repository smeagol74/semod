package org.opengroup.archimate.application.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationCollaboration(
	name: String,
	desc: String = ""
) extends Application
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationCollaboration

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationCollaboration] {
		private[archimate] implicit val tt: ApplicationCollaboration = ApplicationCollaboration.this

		def aggregates(dst: ApplicationComponent): ApplicationCollaboration = tt._rel.aggregates(dst)

		def isSpecializationOf(dst: ApplicationComponent): ApplicationCollaboration = tt._rel.isSpecializationOf(dst)
	}

}
