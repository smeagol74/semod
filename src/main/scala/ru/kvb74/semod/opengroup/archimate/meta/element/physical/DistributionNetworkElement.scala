package ru.kvb74.semod.opengroup.archimate.meta.element.physical

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.PathElement

trait DistributionNetworkElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object DistributionNetworkElement
	extends ElementName

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

	_register(DistributionNetworkElement,
		JR.realizes(PathElement),
		JR.associatedWith(FacilityElement),
		JR.aggregates(FacilityElement),
		JR.aggregates(EquipmentElement),
		JR.associatedWith(MaterialElement),
	)

}

