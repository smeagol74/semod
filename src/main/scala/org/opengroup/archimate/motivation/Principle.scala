package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Principle(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.principle

	object rel extends MotivationElementRelationships[Principle] {

		override private[archimate] implicit val tt:Principle = Principle.this

		def realizes(dst: Outcome): Principle = tt._rel.realizes(dst)

		def associatedWith(dst: Value): Principle = tt._rel.associatedWith(dst)

		def associatedWith(dst: Meaning): Principle = tt._rel.associatedWith(dst)
	}

}
