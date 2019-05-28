package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Goal(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.goal

	object rel extends MotivationElementRelationships[Goal] {

		private[archimate] implicit val tt:Goal = Goal.this

		def associatedWith(dst: Assessment): Goal = tt._rel.associatedWith(dst)

		def associatedWith(dst: Driver): Goal = tt._rel.associatedWith(dst)

		def associatedWith(dst: Value): Goal = tt._rel.associatedWith(dst)

		def associatedWith(dst: Meaning): Goal = tt._rel.associatedWith(dst)
	}

}
