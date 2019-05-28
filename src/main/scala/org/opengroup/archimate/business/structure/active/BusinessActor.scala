package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalActiveStructureElementRelationships}

case class BusinessActor(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with BusinessInternalActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.business.businessActor

	object rel extends BusinessInternalActiveStructureElementRelationships[BusinessActor] {
		private[archimate] implicit val tt: BusinessActor = BusinessActor.this

		def assignedTo(dst: BusinessRole): BusinessActor = tt._rel.assignedTo(dst)
	}

}
