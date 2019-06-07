package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait ImplementationEventElement
	extends Element

case object ImplementationEventElement
	extends ElementName

trait ImplementationEventElementRelationships[T <: ImplementationEventElement]
	extends ElementRelationships[T] {

	_register(ImplementationEventElement)

}
