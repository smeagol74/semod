package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{DriverElement, DriverElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Driver(
	name: String,
	desc: String = ""
) extends Motivation
	with DriverElement {

	case class DriverRelationships(
		override private[archimate] implicit val tt: Driver = Driver.this
	) extends DriverElementRelationships[Driver]

	val rel: DriverRelationships = DriverRelationships()

}
