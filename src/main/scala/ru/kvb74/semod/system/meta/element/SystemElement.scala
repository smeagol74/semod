package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{Element, ElementName, ElementProps, ElementRelationships}

trait SystemElement
  extends Element

case object SystemElement
  extends ElementName

trait SystemElementProps[T <: SystemElement]
  extends ElementProps[T]

trait SystemElementRelationships[T <: SystemElement]
  extends ElementRelationships[T] {

  _register(SystemElement)
}
