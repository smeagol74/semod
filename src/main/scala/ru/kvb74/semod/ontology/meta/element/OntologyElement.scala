package ru.kvb74.semod.ontology.meta.element

import ru.kvb74.semod.meta.{Element, ElementName, ElementProps, ElementRelationships}

trait OntologyElement
  extends Element

case object OntologyElement
  extends ElementName

trait OntologyElementProps[T <: OntologyElement]
  extends ElementProps[T]

trait OntologyElementRelationships[T <: OntologyElement]
  extends ElementRelationships[T] {

  _register(OntologyElement)
}
