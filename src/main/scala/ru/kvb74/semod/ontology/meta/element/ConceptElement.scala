package ru.kvb74.semod.ontology.meta.element

import ru.kvb74.semod.meta.ElementName

trait ConceptElement
  extends OntologyElement

case object ConceptElement
  extends ElementName

trait ConceptElementProps[T <: ConceptElement]
  extends OntologyElementProps[T]

trait ConceptElementRelationships[T <: ConceptElement]
  extends OntologyElementRelationships[T] {

  _register(OntologyElement)
}
