package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement, BusinessInternalActiveStructureElementRelationships}

case class BusinessCollaboration(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with BusinessInternalActiveStructureElement {
	val id: String = IdGenerator.business.businessCollaboration

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessCollaboration]
		with BusinessInternalActiveStructureElementRelationships[BusinessCollaboration] {
		override private[archimate] implicit val tt: BusinessCollaboration = BusinessCollaboration.this

		def aggregates(dst: BusinessInternalActiveStructureElement): BusinessCollaboration = tt._rel.aggregates(dst)
	}

}
