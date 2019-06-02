package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Requirement(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.requirement

	object rel extends MotivationElementRelationships[Requirement] {

		override private[archimate] implicit val tt:Requirement = Requirement.this

		def associatedWith(dst: Value): Requirement = tt._rel.associatedWith(dst)

		def associatedWith(dst: Meaning): Requirement = tt._rel.associatedWith(dst)

		def realizes(dst: Principle): Requirement = tt._rel.realizes(dst)

		def realizes(dst: Outcome): Requirement = tt._rel.realizes(dst)
	}

}
