package ru.kvb74.semod.opengroup.archimate.physical

import ru.kvb74.semod.opengroup.archimate.meta.element.physical.{EquipmentElement, EquipmentElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.PhysicalLayer

case class Equipment(
	name: String,
	desc: String = ""
) extends PhysicalLayer
	with EquipmentElement {

	case class EquipmentRelationships(
		override private[semod] implicit val tt: Equipment = Equipment.this
	) extends EquipmentElementRelationships[Equipment]

	val rel: EquipmentRelationships = EquipmentRelationships()

	_registerPrefix("PE")
}