package org.opengroup.archimate.meta.element.motivation

import org.opengroup.archimate.meta.element.{ElementName, JR, StrategyCoreStructureBehaviorElement}

trait ValueElement
	extends MotivationElement

case object ValueElement
	extends ElementName

trait ValueElementRelationships[T <: ValueElement]
	extends MotivationElementRelationships[T] {

	def associatedWith(dst: StakeholderElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: OutcomeElement): T = tt._rel.associatedWith(dst)

	def associatedWith(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.associatedWith(dst)

	_register(ValueElement,
		JR.associatedWith(StakeholderElement),
		JR.associatedWith(OutcomeElement),
		JR.associatedWith(StrategyCoreStructureBehaviorElement),
	)

}
