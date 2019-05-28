package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Assessment(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.assessment

	object rel extends MotivationElementRelationships[Assessment] {

		private[archimate] implicit val tt:Assessment = Assessment.this

		def associatedWith(dst: Driver): Assessment = tt._rel.associatedWith(dst)

		def associatedWith(dst: Goal): Assessment = tt._rel.associatedWith(dst)

		def associatedWith(dst: Value): Assessment = tt._rel.associatedWith(dst)

		def associatedWith(dst: Meaning): Assessment = tt._rel.associatedWith(dst)
	}

}
