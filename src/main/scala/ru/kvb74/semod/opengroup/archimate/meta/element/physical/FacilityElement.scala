package ru.kvb74.semod.opengroup.archimate.meta.element.physical

import ru.kvb74.semod.{MissedInSpec, Origin}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessActorElement
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.NodeElement
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

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

	@MissedInSpec
	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946113")
	def accesses(dst: MaterialElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: DistributionNetworkElement): T = tt._rel.associatedWith(dst)

	_register(FacilityElement,
		JR.assignedTo(NodeElement),
		JR.assignedTo(BusinessActorElement),
		JR.accesses(MaterialElement)
		//		JR.associatedWith(DistributionNetworkElement),
	)
}

