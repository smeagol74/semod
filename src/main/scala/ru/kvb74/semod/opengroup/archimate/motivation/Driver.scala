package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{DriverElement, DriverElementProps, DriverElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Driver(
	name: String
) extends MotivationLayer
	with DriverElement {

	case class DriverRelationships(
		override private[semod] implicit val tt: Driver = Driver.this
	) extends DriverElementRelationships[Driver]

	val rel: DriverRelationships = DriverRelationships()

	case class DriverProps(
		override private[semod] implicit val tt: Driver = Driver.this
	) extends DriverElementProps[Driver]

	val prop: DriverProps = DriverProps()

	_registerPrefix("MD")
}
