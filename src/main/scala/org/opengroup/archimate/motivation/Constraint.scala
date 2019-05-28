package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Constraint(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.constraint

	object rel extends MotivationElementRelationships[Constraint] {

		private[archimate] implicit val tt:Constraint = Constraint.this

		def isSpecializationOf(dst: Requirement): Constraint = tt._rel.isSpecializationOf(dst)

		def associatedWith(dst: Value): Constraint = tt._rel.associatedWith(dst)

		def associatedWith(dst: Meaning): Constraint = tt._rel.associatedWith(dst)
	}

}
