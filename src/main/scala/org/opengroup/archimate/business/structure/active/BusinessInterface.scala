package org.opengroup.archimate.business.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.business.behavior.BusinessService
import org.opengroup.archimate.element.{ActiveStructureElement, ElementRelationships, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessInternalActiveStructureElement}

case class BusinessInterface(
	name: String,
	desc: String = ""
) extends Business
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.business.businessInterface

	object rel extends ElementRelationships[BusinessInterface] {
		private[archimate] implicit val tt: BusinessInterface = BusinessInterface.this

		def serves(dst: BusinessInternalActiveStructureElement): BusinessInterface = tt._rel.serves(dst)

		def assignedTo(dst: BusinessService): BusinessInterface = tt._rel.assignedTo(dst)
	}

}
