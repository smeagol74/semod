package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{MeaningElement, MeaningElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Meaning(
	name: String,
	desc: String = ""
) extends Motivation
	with MeaningElement {

	object rel extends MeaningElementRelationships[Meaning] {
		override private[archimate] implicit val tt: Meaning = Meaning.this
	}

}
