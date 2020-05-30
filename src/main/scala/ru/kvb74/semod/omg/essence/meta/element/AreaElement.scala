package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait AreaElement
	extends EssenceElement

case object AreaElement
	extends ElementName

trait AreaElementProps[T <: AreaElement]
	extends EssenceElementProps[T]

trait AreaElementRelationships[T <: AreaElement]
	extends EssenceElementRelationships[T] {

	def aggregates(dst: EssenceElement): T = tt._rel.aggregates(dst)

	_register(AreaElement,
		RR.aggregates(EssenceElement)
	)
}


