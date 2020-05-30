package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait ActivityElement
	extends EssenceElement

case object ActivityElement
	extends ElementName

trait ActivityElementProps[T <: ActivityElement]
	extends EssenceElementProps[T]

trait ActivityElementRelationships[T <: ActivityElement]
	extends EssenceElementRelationships[T] {

	_register(ActivityElement)
}

