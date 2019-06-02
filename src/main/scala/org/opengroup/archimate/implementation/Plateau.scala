package org.opengroup.archimate.implementation

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{Element, ElementRelationships}
import org.opengroup.archimate.layer.Implementation

case class Plateau(
	name: String,
	desc: String = ""
) extends Implementation
	with Element {
	val id: String = IdGenerator.implementation.plateau

	object rel extends ElementRelationships[Plateau] {
		private[archimate] implicit val tt: Plateau = Plateau.this
	}

}
