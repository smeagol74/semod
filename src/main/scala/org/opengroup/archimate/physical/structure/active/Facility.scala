package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.business.structure.active.BusinessActor
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Physical, TechnologyNodeElement}

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
	*
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946108
	*/
case class Facility(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyNodeElement {
	val id: String = IdGenerator.physical.facility

	object rel extends FacilityRelationships[Facility] {
		private[archimate] implicit val tt: Facility = Facility.this
	}

}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946104
	*/
trait FacilityRelationships[T <: Facility]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def assignedTo(dst: TechnologyNodeElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: BusinessActor): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: DistributionNetwork): T = tt._rel.associatedWith(dst)
}
