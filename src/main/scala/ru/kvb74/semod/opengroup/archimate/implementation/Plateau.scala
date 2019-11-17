package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{PlateauElement, PlateauElementProps, PlateauElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class Plateau(
	name: String
) extends ImplementationLayer
	with PlateauElement {

	case class PlateauRelationships(
		override private[semod] implicit val tt: Plateau = Plateau.this
	) extends PlateauElementRelationships[Plateau]

	val rel: PlateauRelationships = PlateauRelationships()

	case class PlateauProps(
		override private[semod] implicit val tt: Plateau = Plateau.this
	) extends PlateauElementProps[Plateau]

	val prop: PlateauProps = PlateauProps()

	_registerPrefix("IP")
}
