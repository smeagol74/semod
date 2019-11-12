package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ActiveStructureElement, ArchimateElementRelationships}

trait StakeholderElement
	extends ActiveStructureElement

case object StakeholderElement
	extends ElementName

trait StakeholderElementRelationships[T <: StakeholderElement]
	extends ArchimateElementRelationships[T] {

	def influences(dst: StakeholderElement, label: String = ""): T = tt._rel.influences(dst, label)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MotivationElement): T = tt._rel.associatedWith(dst)

	_register(StakeholderElement,
		RR.influences(StakeholderElement),
		//		JR.associatedWith(MotivationElement)
	)

}
