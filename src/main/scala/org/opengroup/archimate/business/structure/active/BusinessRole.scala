package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalActiveStructureElementRelationships}

case class BusinessRole(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalActiveStructureElement {
	val id: String = IdGenerator.business.businessRole

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessRole]
		with BusinessInternalActiveStructureElementRelationships[BusinessRole] {
		override private[archimate] implicit val tt: BusinessRole = BusinessRole.this
	}
}
