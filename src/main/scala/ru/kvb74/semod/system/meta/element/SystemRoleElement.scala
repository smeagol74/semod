package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.ElementName

trait SystemRoleElement
  extends SystemElement

case object SystemRoleElement
  extends ElementName

trait SystemRoleElementProps[T <: SystemRoleElement]
  extends SystemElementProps[T]

trait SystemRoleElementRelationships[T <: SystemRoleElement]
  extends SystemElementRelationships[T] {

  _register(SystemRoleElement)
}
