package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Driver(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.driver

	object rel extends MotivationElementRelationships[Driver] {

		override private[archimate] implicit val tt: Driver = Driver.this

		def associatedWith(dst: Assessment): Driver = tt._rel.associatedWith(dst)

		def associatedWith(dst: Goal): Driver = tt._rel.associatedWith(dst)

		def associatedWith(dst: Value): Driver = tt._rel.associatedWith(dst)

		def associatedWith(dst: Meaning): Driver = tt._rel.associatedWith(dst)
	}

}
