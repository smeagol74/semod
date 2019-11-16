package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemSupportElement
  extends SystemElement

case object SystemSupportElement
  extends ElementName

trait SystemSupportElementRelationships[T <: SystemSupportElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: PlaceholderElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOtherElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOurElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemRoleElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOfInterestElement): T = tt._rel.composedOf(dst)

  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOfInterestElement,
    RR.composedOf(PlaceholderElement),
    RR.composedOf(SystemOtherElement),
    RR.composedOf(SystemOurElement),
    RR.composedOf(SystemRoleElement),
    RR.composedOf(SystemOfInterestElement),
    RR.realizes(PlaceholderElement),
  )
}
