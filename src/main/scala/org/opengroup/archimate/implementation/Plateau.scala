package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{PlateauElement, PlateauElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class Plateau(
	name: String,
	desc: String = ""
) extends Implementation
	with PlateauElement {

	object rel extends PlateauElementRelationships[Plateau] {
		private[archimate] implicit val tt: Plateau = Plateau.this
	}

}
