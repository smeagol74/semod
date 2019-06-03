package org.opengroup.archimate.meta.element.motivation

import org.opengroup.archimate.meta.element.StrategyCoreStructureBehaviorElement

trait MeaningElement
	extends MotivationElement

trait MeaningElementRelationships[T <: MeaningElement]
	extends MotivationElementRelationships[T] {
	def associatedWith(dst: StakeholderElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.associatedWith(dst)

}
