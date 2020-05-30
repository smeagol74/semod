package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait AlphaStateElement
	extends EssenceElement


case object AlphaStateElement
	extends ElementName

trait AlphaStateElementProps[T <: AlphaStateElement]
	extends EssenceElementProps[T]

trait AlphaStateElementRelationships[T <: AlphaStateElement]
	extends EssenceElementRelationships[T] {

	_register(AlphaStateElement)
}
