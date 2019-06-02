package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Physical

case class Facility(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.physical.facility

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Facility] {
		private[archimate] implicit val tt: Facility = Facility.this
	}

}
