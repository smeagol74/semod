package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementProps, ArchimateElementRelationships}

trait MotivationElement
	extends ArchimateElement

case object MotivationElement
	extends ElementName

trait MotivationElementProps[T <: ArchimateElement]
	extends ArchimateElementProps[T]

trait MotivationElementRelationships[T <: ArchimateElement]
	extends ArchimateElementRelationships[T] {

	def influences(dst: MotivationElement, label: String): T = tt._rel.influences(dst, label)

	_register(MotivationElement,
		RR.influences(MotivationElement)
	)

}