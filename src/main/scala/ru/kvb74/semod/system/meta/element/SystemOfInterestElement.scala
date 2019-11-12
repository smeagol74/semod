package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemOfInterestElement
  extends SystemElement

case object SystemOfInterestElement
  extends ElementName

trait SystemOfInterestElementRelationships[T <: SystemOfInterestElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: SystemElement): T = tt._rel.composedOf(dst)

  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOfInterestElement,
    RR.composedOf(SystemElement),
    RR.realizes(PlaceholderElement),
  )
}
