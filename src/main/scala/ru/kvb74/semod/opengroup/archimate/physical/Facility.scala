package ru.kvb74.semod.opengroup.archimate.physical

import ru.kvb74.semod.opengroup.archimate.meta.element.physical.{FacilityElement, FacilityElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Physical

/**
	* A facility represents a physical structure or environment.
	*
	* A facility is a specialization of a node. It represents a physical resource
	* that has the capability of facilitating (e.g., housing or locating) the use
	* of equipment. It is typically used to model factories, buildings, or outdoor
	* constructions that have an important role in production or distribution processes.
	* Examples of facilities include a factory, a laboratory, a warehouse, a shopping mall,
	* a cave, or a spaceship. Facilities may be composite; i.e., consist of sub-facilities.
	*
	* Facilities can be interconnected by distribution networks. A facility can serve other
	* facilities, and also other active structure elements such as business roles and actors.
	* A facility can be composed of other facilities and can be aggregated in a location.
	*
	* @param name The name of a facility should preferably be a noun referring to the type of facility; e.g., “Rotterdam harbor oil refinery”.
	* @param desc
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946108
	*/
case class Facility(
	name: String,
	desc: String = ""
) extends Physical
	with FacilityElement {

	case class FacilityRelationships(
		private[archimate] implicit val tt: Facility = Facility.this
	) extends FacilityElementRelationships[Facility]

	val rel: FacilityRelationships = FacilityRelationships()

}
