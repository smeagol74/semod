package org.opengroup.archimate.application.behavior

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.application.structure.active.ApplicationComponent
import org.opengroup.archimate.application.structure.passive.DataObject
import org.opengroup.archimate.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Application, ApplicationInternalBehaviorElement}

case class ApplicationService(
	name: String,
	desc: String = ""
) extends Application
	with BehaviorElement
	with StrategyCoreStructureBehaviorElement {

	val id: String = IdGenerator.application.applicationService

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationService] {
		private[archimate] implicit val tt: ApplicationService = ApplicationService.this

		def triggers(dst: ApplicationService): ApplicationService = tt._rel.triggers(dst)

		def flowsTo(dst: ApplicationService): ApplicationService = tt._rel.flowsTo(dst)

		def triggers(dst: ApplicationEvent): ApplicationService = tt._rel.flowsTo(dst)

		def flowsTo(dst: ApplicationEvent): ApplicationService = tt._rel.flowsTo(dst)

		def accesses(dst: DataObject): ApplicationService = tt._rel.accesses(dst)

		def serves(dst: ApplicationInternalBehaviorElement): ApplicationService = tt._rel.serves(dst)

		def serves(dst: ApplicationComponent): ApplicationService = tt._rel.serves(dst)
	}

}
