package org.opengroup.archimate.meta.element.physical

import org.opengroup.archimate.meta.element.technology.PathElement
import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait DistributionNetworkElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946104
	*/
trait DistributionNetworkElementRelationships[T <: DistributionNetworkElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def realizes(dst: PathElement): T = tt._rel.realizes(dst)

	def associatedWith(dst: FacilityElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: FacilityElement): T = tt._rel.aggregates(dst)

	def aggregates(dst: EquipmentElement): T = tt._rel.aggregates(dst)

	def associatedWith(dst: MaterialElement): T = tt._rel.associatedWith(dst)
}

