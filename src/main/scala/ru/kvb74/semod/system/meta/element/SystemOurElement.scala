package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemOurElement
  extends SystemElement

case object SystemOurElement
  extends ElementName

trait SystemOurElementRelationships[T <: SystemOurElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: SystemElement): T = tt._rel.composedOf(dst)

  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOurElement,
    RR.composedOf(SystemElement),
    RR.realizes(PlaceholderElement),
  )
}
