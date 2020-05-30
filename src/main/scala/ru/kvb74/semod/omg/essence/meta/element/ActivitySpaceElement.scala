package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait ActivitySpaceElement
	extends EssenceElement

case object ActivitySpaceElement
	extends ElementName

trait ActivitySpaceElementProps[T <: ActivitySpaceElement]
	extends EssenceElementProps[T]

trait ActivitySpaceElementRelationships[T <: ActivitySpaceElement]
	extends EssenceElementRelationships[T] {

	_register(ActivitySpaceElement)
}
