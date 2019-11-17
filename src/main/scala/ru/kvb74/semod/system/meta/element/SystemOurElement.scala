package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemOurElement
  extends SystemElement

case object SystemOurElement
  extends ElementName

trait SystemOurElementProps[T <: SystemOurElement]
  extends SystemElementProps[T]

trait SystemOurElementRelationships[T <: SystemOurElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: PlaceholderElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOtherElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOfInterestElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemRoleElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemEnablingElement): T = tt._rel.composedOf(dst)

  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOfInterestElement,
    RR.composedOf(PlaceholderElement),
    RR.composedOf(SystemOtherElement),
    RR.composedOf(SystemOfInterestElement),
    RR.composedOf(SystemRoleElement),
    RR.composedOf(SystemEnablingElement),
    RR.realizes(PlaceholderElement),
  )
}
