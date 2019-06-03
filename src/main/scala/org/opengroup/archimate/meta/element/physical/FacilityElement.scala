package org.opengroup.archimate.meta.element.physical

import org.opengroup.archimate.meta.element.business.BusinessActorElement
import org.opengroup.archimate.meta.element.technology.NodeElement
import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait FacilityElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946104
	*/
trait FacilityElementRelationships[T <: FacilityElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def assignedTo(dst: NodeElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: BusinessActorElement): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: DistributionNetworkElement): T = tt._rel.associatedWith(dst)
}

