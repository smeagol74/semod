package org.opengroup.archimate.business.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element._
import org.opengroup.archimate.layer.{Business, BusinessPassiveStructureElement}

case class BusinessObject(
	name: String,
	desc: String = ""
) extends Business
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with BusinessPassiveStructureElement {
	val id: String = IdGenerator.business.businessObject

	object rel extends StrategyCoreStructureBehaviorElementRelationships[BusinessObject] {
		override private[archimate] implicit val tt: BusinessObject = BusinessObject.this
	}

}
