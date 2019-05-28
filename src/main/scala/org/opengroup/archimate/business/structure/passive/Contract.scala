package org.opengroup.archimate.business.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ElementRelationships, PassiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessPassiveStructureElement}

case class Contract(
	name: String,
	desc: String = ""
) extends Business
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with BusinessPassiveStructureElement {
	val id: String = IdGenerator.business.contract

	object rel extends ElementRelationships[Contract] {
		private[archimate] implicit val tt: Contract = Contract.this
	}

}
