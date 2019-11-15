package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{PlaceholderElement, PlaceholderElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class Placeholder(
                        name: String,
                        desc: String = ""
                      ) extends SystemLayer
  with PlaceholderElement {

  case class PlaceholderRelationships(
                                       override private[semod] implicit val tt: Placeholder = Placeholder.this
                                     ) extends PlaceholderElementRelationships[Placeholder]

  val rel: PlaceholderRelationships = PlaceholderRelationships()

  _registerPrefix("SP")
}
