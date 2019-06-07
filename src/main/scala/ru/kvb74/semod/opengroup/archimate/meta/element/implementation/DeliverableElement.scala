package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait DeliverableElement
	extends Element

case object DeliverableElement
	extends ElementName

trait DeliverableElementRelationships[T <: DeliverableElement]
	extends ElementRelationships[T] {

	_register(DeliverableElement)

}