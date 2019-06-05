package org.opengroup.archimate.meta.element.physical

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.business.BusinessActorElement
import org.opengroup.archimate.meta.element.technology.NodeElement

trait FacilityElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

case object FacilityElement
	extends ElementName

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946104
	*/
trait FacilityElementRelationships[T <: FacilityElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def assignedTo(dst: NodeElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: BusinessActorElement): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: DistributionNetworkElement): T = tt._rel.associatedWith(dst)

	_register(FacilityElement,
		JR.assignedTo(NodeElement),
		JR.assignedTo(BusinessActorElement),
		JR.associatedWith(DistributionNetworkElement),
	)
}

