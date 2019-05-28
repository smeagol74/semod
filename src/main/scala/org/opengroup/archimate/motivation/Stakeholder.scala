package org.opengroup.archimate.motivation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, ElementRelationships}
import org.opengroup.archimate.layer.{Motivation, MotivationElement}

case class Stakeholder(
	name: String,
	desc: String = ""
) extends Motivation
	with ActiveStructureElement {
	val id: String = IdGenerator.motivation.stakeholder

	object rel extends ElementRelationships[Stakeholder] {
		private[archimate] implicit val tt: Stakeholder = Stakeholder.this

		def influences(dst: Stakeholder, label: String = ""): Stakeholder = tt._rel.influences(dst, label)

		def associatedWith(dst: MotivationElement): Stakeholder = tt._rel.associatedWith(dst)
	}

}