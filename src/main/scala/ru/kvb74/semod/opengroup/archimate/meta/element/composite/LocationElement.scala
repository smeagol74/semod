package ru.kvb74.semod.opengroup.archimate.meta.element.composite

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}

trait LocationElement
	extends Element

case object LocationElement
	extends ElementName

trait LocationElementRelationships[T <: LocationElement]
	extends ElementRelationships[T] {

	def aggregates(dst: Element): T = tt._rel.aggregates(dst)

	_register(GroupingElement,
		JR.aggregates(Element)
	)

}

