package ru.kvb74.semod.opengroup.archimate.meta.element

import ru.kvb74.semod.meta.{Element, ElementName, ElementRelationships, RR}

trait ArchimateElement
  extends Element

case object ArchimateElement
  extends ElementName

trait ArchimateElementRelationships[T <: ArchimateElement] extends ElementRelationships[T] {

  _register(ArchimateElement)
}