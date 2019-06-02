package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Outcome(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.outcome

	object rel extends MotivationElementRelationships[Outcome] {
		override private[archimate] implicit val tt: Outcome = Outcome.this

		def realizes(dst: Goal): Outcome = tt._rel.realizes(dst)

		def associatedWith(dst: Value): Outcome = tt._rel.associatedWith(dst)
	}

}
