package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{PlateauElement, PlateauElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class Plateau(
	name: String,
	desc: String = ""
) extends ImplementationLayer
	with PlateauElement {

	case class PlateauRelationships(
		override private[semod] implicit val tt: Plateau = Plateau.this
	) extends PlateauElementRelationships[Plateau]

	val rel: PlateauRelationships = PlateauRelationships()

	_registerPrefix("IP")
}
