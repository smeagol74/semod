package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{PrincipleElement, PrincipleElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Principle(
	name: String,
	desc: String = ""
) extends Motivation
	with PrincipleElement {

	object rel extends PrincipleElementRelationships[Principle] {
		override private[archimate] implicit val tt: Principle = Principle.this
	}

}
