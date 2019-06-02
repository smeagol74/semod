package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.application.structure.passive.DataObject
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class ApplicationService(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {

	val id: String = IdGenerator.application.applicationService

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationService] {
		private[archimate] implicit val tt: ApplicationService = ApplicationService.this

		def accesses(dst: DataObject): ApplicationService = tt._rel.accesses(dst)
	}

}
