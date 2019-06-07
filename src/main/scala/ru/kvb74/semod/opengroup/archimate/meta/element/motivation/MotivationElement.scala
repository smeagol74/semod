package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}

trait MotivationElement
	extends Element

case object MotivationElement
	extends ElementName

trait MotivationElementRelationships[T <: Element]
	extends ElementRelationships[T] {

	def influences(dst: MotivationElement, label: String): T = tt._rel.influences(dst, label)

	_register(MotivationElement,
		JR.influences(MotivationElement)
	)

}