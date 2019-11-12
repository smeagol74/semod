package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemOtherElement
  extends SystemElement

case object SystemOtherElement
  extends ElementName

trait SystemOtherElementRelationships[T <: SystemOtherElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: SystemElement): T = tt._rel.composedOf(dst)

  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOtherElement,
    RR.composedOf(SystemElement),
    RR.realizes(PlaceholderElement),
  )
}
