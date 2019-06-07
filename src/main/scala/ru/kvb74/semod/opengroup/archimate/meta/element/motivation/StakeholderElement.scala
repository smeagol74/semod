package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{ActiveStructureElement, ElementName, ElementRelationships, JR}

trait StakeholderElement
	extends ActiveStructureElement

case object StakeholderElement
	extends ElementName

trait StakeholderElementRelationships[T <: StakeholderElement]
	extends ElementRelationships[T] {

	def influences(dst: StakeholderElement, label: String = ""): T = tt._rel.influences(dst, label)

	def associatedWith(dst: MotivationElement): T = tt._rel.associatedWith(dst)

	_register(StakeholderElement,
		JR.influences(StakeholderElement),
		JR.associatedWith(MotivationElement)
	)

}
