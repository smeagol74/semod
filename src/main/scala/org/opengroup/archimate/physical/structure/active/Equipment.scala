package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Physical

case class Equipment(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.physical.equipment

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Equipment] {
		private[archimate] implicit val tt: Equipment = Equipment.this
	}

}
