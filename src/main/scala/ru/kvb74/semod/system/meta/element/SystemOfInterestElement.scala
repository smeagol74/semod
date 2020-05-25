package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemOfInterestElement
  extends SystemElement

case object SystemOfInterestElement
  extends ElementName

trait SystemOfInterestElementProps[T <: SystemOfInterestElement]
  extends SystemElementProps[T]

trait SystemOfInterestElementRelationships[T <: SystemOfInterestElement]
  extends SystemElementRelationships[T] {

  def composedOf(dst: PlaceholderElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOtherElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemOurElement): T = tt._rel.composedOf(dst)

  def composedOf(dst: SystemRoleElement): T = tt._rel.composedOf(dst)


  def composedOf(dst: SystemEnablingElement): T = tt._rel.composedOf(dst)
  def composedOf(dst: SystemSupraOfInterestElement): T = tt._rel.composedOf(dst)
  def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

  _register(SystemOfInterestElement,
    RR.composedOf(PlaceholderElement),
    RR.composedOf(SystemOtherElement),
    RR.composedOf(SystemOurElement),
    RR.composedOf(SystemRoleElement),
    RR.composedOf(SystemEnablingElement),
    RR.composedOf(SystemSupraOfInterestElement),
    RR.realizes(PlaceholderElement),
  )
}
