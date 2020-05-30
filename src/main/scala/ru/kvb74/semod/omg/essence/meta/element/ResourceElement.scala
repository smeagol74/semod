package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait ResourceElement
	extends EssenceElement

case object ResourceElement
	extends ElementName

trait ResourceElementProps[T <: ResourceElement]
	extends EssenceElementProps[T]

trait ResourceElementRelationships[T <: ResourceElement]
	extends EssenceElementRelationships[T] {

	_register(ResourceElement)
}

