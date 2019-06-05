package org.opengroup.archimate.physical

import org.opengroup.archimate.meta.element.physical.{EquipmentElement, EquipmentElementRelationships}
import org.opengroup.archimate.meta.layer.Physical

case class Equipment(
	name: String,
	desc: String = ""
) extends Physical
	with EquipmentElement {

	case class EquipmentRelationships(
		override private[archimate] implicit val tt: Equipment = Equipment.this
	) extends EquipmentElementRelationships[Equipment]

	val rel: EquipmentRelationships = EquipmentRelationships()

}