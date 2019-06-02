package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalActiveStructureElementRelationships}

case class BusinessActor(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalActiveStructureElement {
	val id: String = IdGenerator.business.businessActor

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessActor]
		with BusinessInternalActiveStructureElementRelationships[BusinessActor] {
		override private[archimate] implicit val tt: BusinessActor = BusinessActor.this

		def assignedTo(dst: BusinessRole): BusinessActor = tt._rel.assignedTo(dst)
	}

}
