package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait AlphaElement
	extends EssenceElement

case object AlphaElement
	extends ElementName

trait AlphaElementProps[T <: AlphaElement]
	extends EssenceElementProps[T]

trait AlphaElementRelationships[T <: AlphaElement]
	extends EssenceElementRelationships[T] {

	_register(AlphaElement)
}
