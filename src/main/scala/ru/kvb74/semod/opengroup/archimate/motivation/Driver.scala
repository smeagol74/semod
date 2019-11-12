package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{DriverElement, DriverElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Driver(
	name: String,
	desc: String = ""
) extends Motivation
	with DriverElement {

	case class DriverRelationships(
		override private[semod] implicit val tt: Driver = Driver.this
	) extends DriverElementRelationships[Driver]

	val rel: DriverRelationships = DriverRelationships()

	_registerPrefix("MD")
}
