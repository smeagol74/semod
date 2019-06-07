package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{DeviceElement, DeviceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class Device(
	name: String,
	desc: String = ""
) extends Technology
	with DeviceElement {

	case class DeviceRelationships(
		override private[archimate] implicit val tt: Device = Device.this
	) extends DeviceElementRelationships[Device]

	val rel: DeviceRelationships = DeviceRelationships()

}
