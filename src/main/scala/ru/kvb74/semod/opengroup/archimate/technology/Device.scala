package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{DeviceElement, DeviceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class Device(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with DeviceElement {

	case class DeviceRelationships(
		override private[semod] implicit val tt: Device = Device.this
	) extends DeviceElementRelationships[Device]

	val rel: DeviceRelationships = DeviceRelationships()

	_registerPrefix("TD")
}
