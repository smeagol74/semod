package org.opengroup.archimate.physical

import org.opengroup.archimate.meta.element.physical.{EquipmentElement, EquipmentElementRelationships}
import org.opengroup.archimate.meta.layer.Physical

case class Equipment(
	name: String,
	desc: String = ""
) extends Physical
	with EquipmentElement {

	object rel extends EquipmentElementRelationships[Equipment] {
		private[archimate] implicit val tt: Equipment = Equipment.this
	}

}