package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.StrategyCoreStructureBehaviorElement
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Meaning(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.meaning

	object rel extends MotivationElementRelationships[Meaning] {

		private[archimate] implicit val tt:Meaning = Meaning.this

		def associatedWith(dst: Stakeholder): Meaning = tt._rel.associatedWith(dst)

		def associatedWith(dst: StrategyCoreStructureBehaviorElement): Meaning = tt._rel.associatedWith(dst)
	}

}
