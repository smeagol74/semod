package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{Element, ElementName, ElementRelationships}

trait SystemElement
  extends Element

case object SystemElement
  extends ElementName

trait SystemElementRelationships[T <: SystemElement]
  extends ElementRelationships[T] {

  _register(SystemElement)
}
