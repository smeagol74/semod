package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalActiveStructureElementRelationships}

case class BusinessCollaboration(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with BusinessInternalActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.business.businessCollaboration

	object rel extends BusinessInternalActiveStructureElementRelationships[BusinessCollaboration] {
		private[archimate] implicit val tt: BusinessCollaboration = BusinessCollaboration.this

		def aggregates(dst: BusinessInternalActiveStructureElement): BusinessCollaboration = tt._rel.aggregates(dst)
	}

}
