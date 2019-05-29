package org.opengroup.archimate.application.structure.passive

import org.opengroup.archimate.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Application

case class DataObject(
	name: String,
	desc: String = ""
) extends Application
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id = ""

	object rel extends StrategyCoreStructureBehaviorElementRelationships[DataObject] {
		override private[archimate] implicit val tt: DataObject = DataObject.this
	}

}
