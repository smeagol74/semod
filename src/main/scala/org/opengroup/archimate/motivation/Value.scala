package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.StrategyCoreStructureBehaviorElement
import org.opengroup.archimate.layer.{Motivation, MotivationElement, MotivationElementRelationships}

case class Value(
	name: String,
	desc: String = ""
) extends Motivation
	with MotivationElement {
	val id: String = IdGenerator.motivation.value

	object rel extends MotivationElementRelationships[Value] {

		override private[archimate] implicit val tt: Value = Value.this

		def associatedWith(dst: Stakeholder): Value = tt._rel.associatedWith(dst)

		def associatedWith(dst: Outcome): Value = tt._rel.associatedWith(dst)

		def associatedWith(dst: StrategyCoreStructureBehaviorElement): Value = tt._rel.associatedWith(dst)
	}

}
