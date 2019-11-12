package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.ElementName

trait SystemRoleElement
  extends SystemElement

case object SystemRoleElement
  extends ElementName

trait SystemRoleElementRelationships[T <: SystemRoleElement]
  extends SystemElementRelationships[T] {

  _register(SystemRoleElement)
}
