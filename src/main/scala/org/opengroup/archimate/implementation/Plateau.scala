package org.opengroup.archimate.implementation

import org.opengroup.archimate.meta.element.implementation.{PlateauElement, PlateauElementRelationships}
import org.opengroup.archimate.meta.layer.Implementation

case class Plateau(
	name: String,
	desc: String = ""
) extends Implementation
	with PlateauElement {

	case class PlateauRelationships(
		override private[archimate] implicit val tt: Plateau = Plateau.this
	) extends PlateauElementRelationships[Plateau]

	val rel: PlateauRelationships = PlateauRelationships()

}
