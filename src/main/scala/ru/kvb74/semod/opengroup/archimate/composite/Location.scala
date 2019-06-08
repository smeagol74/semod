package ru.kvb74.semod.opengroup.archimate.composite

import ru.kvb74.semod.opengroup.archimate.meta.element.composite.{LocationElement, LocationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Composite

case class Location(
	name: String,
	desc: String = ""
) extends Composite
	with LocationElement {

	case class LocationRelationships(
		private[archimate] implicit val tt: Location = Location.this
	) extends LocationElementRelationships[Location]

	val rel: LocationRelationships = LocationRelationships()

}
