package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{PlaceholderElement, PlaceholderElementRelationships}
import ru.kvb74.semod.system.meta.layer.System

case class Placeholder(
                        name: String,
                        desc: String = ""
                      ) extends System
  with PlaceholderElement {

  case class PlaceholderRelationships(
                                       override private[semod] implicit val tt: Placeholder = Placeholder.this
                                     ) extends PlaceholderElementRelationships[Placeholder]

  val rel: PlaceholderRelationships = PlaceholderRelationships()

  _registerPrefix("SP")
}
