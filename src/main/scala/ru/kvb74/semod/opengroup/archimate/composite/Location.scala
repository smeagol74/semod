package ru.kvb74.semod.opengroup.archimate.composite

import ru.kvb74.semod.opengroup.archimate.meta.element.composite.{LocationElement, LocationElementProps, LocationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.CompositeLayer

case class Location(
	name: String
) extends CompositeLayer
	with LocationElement {

	case class LocationRelationships(
		override private[semod] implicit val tt: Location = Location.this
	) extends LocationElementRelationships[Location]

	val rel: LocationRelationships = LocationRelationships()

	case class LocationProps(
		override private[semod] implicit val tt: Location = Location.this
	) extends LocationElementProps[Location]

	val prop: LocationProps = LocationProps()

	_registerPrefix("OL")
}
