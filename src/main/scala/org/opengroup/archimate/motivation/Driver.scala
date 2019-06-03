package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{DriverElement, DriverElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Driver(
	name: String,
	desc: String = ""
) extends Motivation
	with DriverElement {

	object rel extends DriverElementRelationships[Driver] {
		override private[archimate] implicit val tt: Driver = Driver.this
	}

}
