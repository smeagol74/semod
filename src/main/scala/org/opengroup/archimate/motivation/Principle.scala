package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{PrincipleElement, PrincipleElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Principle(
	name: String,
	desc: String = ""
) extends Motivation
	with PrincipleElement {

	case class PrincipleRelationships(
		override private[archimate] implicit val tt: Principle = Principle.this
	) extends PrincipleElementRelationships[Principle]

	val rel: PrincipleRelationships = PrincipleRelationships()

}
