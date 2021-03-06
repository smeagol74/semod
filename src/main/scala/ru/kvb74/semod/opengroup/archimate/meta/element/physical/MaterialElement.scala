package ru.kvb74.semod.opengroup.archimate.meta.element.physical

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyObjectElementProps, TechnologyObjectElementRelationships}

trait MaterialElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyObjectElement

case object MaterialElement
	extends ElementName

trait MaterialElementProps[T <: MaterialElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with TechnologyObjectElementProps[T]

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946105
	*/
trait MaterialElementRelationships[T <: MaterialElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyObjectElementRelationships[T] {

	def specializationOf(dst: TechnologyObjectElement): T = tt._rel.specializationOf(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: DistributionNetworkElement): T = tt._rel.associatedWith(dst)

	_register(MaterialElement,
		RR.specializationOf(TechnologyObjectElement),
		//		JR.associatedWith(DistributionNetworkElement)
	)
}
