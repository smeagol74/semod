package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.ElementName

trait PlaceholderElement
  extends SystemElement

case object PlaceholderElement
  extends ElementName

trait PlaceholderElementProps[T <: PlaceholderElement]
  extends SystemElementProps[T]

trait PlaceholderElementRelationships[T <: PlaceholderElement]
  extends SystemElementRelationships[T] {

  _register(PlaceholderElement)
}
