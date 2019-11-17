package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemOtherElement
  extends SystemElement

case object SystemOtherElement
  extends ElementName

trait SystemOtherElementProps[T <: SystemOtherElement]
  extends SystemElementProps[T]

trait SystemOtherElementRelationships[T <: SystemOtherElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: PlaceholderElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOfInterestElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOurElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemRoleElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemEnablingElement): T = tt._rel.composedOf(dst)

  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOfInterestElement,
    RR.composedOf(PlaceholderElement),
    RR.composedOf(SystemOfInterestElement),
    RR.composedOf(SystemOurElement),
    RR.composedOf(SystemRoleElement),
    RR.composedOf(SystemEnablingElement),
    RR.realizes(PlaceholderElement),
  )
}
