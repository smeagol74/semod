package ru.kvb74.semod.ontology.meta.layer

import ru.kvb74.semod.meta.Layer

trait OntologyLayer extends Layer {
  override def layerName = "Ontology"
}
case object OntologyLayer extends OntologyLayer
