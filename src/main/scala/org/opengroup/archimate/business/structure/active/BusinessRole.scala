package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalActiveStructureElementRelationships}

case class BusinessRole(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with BusinessInternalActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.business.businessRole

	object rel extends BusinessInternalActiveStructureElementRelationships[BusinessRole] {
		private[archimate] implicit val tt: BusinessRole = BusinessRole.this
	}
}
