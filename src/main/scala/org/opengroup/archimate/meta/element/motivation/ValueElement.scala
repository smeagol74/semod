package org.opengroup.archimate.meta.element.motivation

import org.opengroup.archimate.meta.element.StrategyCoreStructureBehaviorElement

trait ValueElement
	extends MotivationElement

trait ValueElementRelationships[T <: ValueElement]
	extends MotivationElementRelationships[T] {
	def associatedWith(dst: StakeholderElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: OutcomeElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.associatedWith(dst)

}
