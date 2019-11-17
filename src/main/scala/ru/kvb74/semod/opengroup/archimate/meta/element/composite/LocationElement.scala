package ru.kvb74.semod.opengroup.archimate.meta.element.composite

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementProps, ArchimateElementRelationships}

trait LocationElement
	extends ArchimateElement

case object LocationElement
	extends ElementName

trait LocationElementProps[T <: LocationElement]
	extends ArchimateElementProps[T]

trait LocationElementRelationships[T <: LocationElement]
	extends ArchimateElementRelationships[T] {

	def aggregates(dst: ArchimateElement): T = tt._rel.aggregates(dst)

	_register(LocationElement,
		RR.aggregates(ArchimateElement)
	)

}

