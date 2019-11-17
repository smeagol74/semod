package ru.kvb74.semod.opengroup.archimate.meta.element

import ru.kvb74.semod.meta.{Element, ElementName, ElementProps, ElementRelationships}

trait ArchimateElement
  extends Element

case object ArchimateElement
  extends ElementName

trait ArchimateElementProps[T <: ArchimateElement] extends ElementProps[T]

trait ArchimateElementRelationships[T <: ArchimateElement] extends ElementRelationships[T] {

  _register(ArchimateElement)
}