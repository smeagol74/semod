package ru.kvb74.semod.ontology.ontology

import ru.kvb74.semod.ontology.meta.element.{ConceptElement, ConceptElementProps, ConceptElementRelationships}
import ru.kvb74.semod.ontology.meta.layer.OntologyLayer

case class Concept(
	name: String
) extends OntologyLayer
	with ConceptElement {

	case class ConceptRelationships(
		override private[semod] implicit val tt: Concept = Concept.this
	) extends ConceptElementRelationships[Concept]

	val rel: ConceptRelationships = ConceptRelationships()

	case class ConceptProps(
		override private[semod] implicit val tt: Concept = Concept.this
	) extends ConceptElementProps[Concept]

	val prop: ConceptProps = ConceptProps()

	_registerPrefix("OC")
}
