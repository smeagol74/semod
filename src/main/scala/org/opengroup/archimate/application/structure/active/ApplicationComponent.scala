package org.opengroup.archimate.application.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.application.behavior.ApplicationEvent
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Application, ApplicationInternalBehaviorElement}

case class ApplicationComponent(
	name: String,
	desc: String = ""
) extends Application
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.application.applicationComponent

	object rel extends StrategyCoreStructureBehaviorElementRelationships[ApplicationComponent] {
		private[archimate] implicit val tt: ApplicationComponent = ApplicationComponent.this

		def isComposedOf(dst: ApplicationInterface): ApplicationComponent = tt._rel.isComposedOf(dst)

		def assignedTo(dst: ApplicationInternalBehaviorElement): ApplicationComponent = tt._rel.assignedTo(dst)

		def assignedTo(dst: ApplicationEvent): ApplicationComponent = tt._rel.assignedTo(dst)

		def realizes(dst: ApplicationComponent): ApplicationComponent = tt._rel.realizes(dst)
	}

}
