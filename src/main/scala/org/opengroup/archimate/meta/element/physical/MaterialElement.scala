package org.opengroup.archimate.meta.element.physical

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyObjectElementRelationships}

trait MaterialElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyObjectElement

case object MaterialElement
	extends ElementName

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946105
	*/
trait MaterialElementRelationships[T <: MaterialElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyObjectElementRelationships[T] {

	def specializationOf(dst: TechnologyObjectElement): T = tt._rel.specializationOf(dst)

	def associatedWith(dst: DistributionNetworkElement): T = tt._rel.associatedWith(dst)

	_register(MaterialElement,
		JR.specializationOf(TechnologyObjectElement),
		JR.associatedWith(DistributionNetworkElement)
	)
}
