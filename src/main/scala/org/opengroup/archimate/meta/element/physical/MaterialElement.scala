package org.opengroup.archimate.meta.element.physical

import org.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyObjectElementRelationships}
import org.opengroup.archimate.meta.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait MaterialElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyObjectElement

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946105
	*/
trait MaterialElementRelationships[T <: MaterialElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyObjectElementRelationships[T] {
	def isSpecializationOf(dst: TechnologyObjectElement): T = tt._rel.isSpecializationOf(dst)

	def associatedWith(dst: DistributionNetworkElement): T = tt._rel.associatedWith(dst)
}
