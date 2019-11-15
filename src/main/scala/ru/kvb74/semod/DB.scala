package ru.kvb74.semod

import ru.kvb74.semod.meta.{Element, Layer}

import scala.collection.mutable

object DB {
  val _elements = mutable.Set.empty[Element]

  def register(element: Element): Unit = _elements.add(element)

  def byLayer(layer: Layer): Set[Element] = _elements.filter(e => e match {
    case l: Layer =>
      l.layerName.equalsIgnoreCase(layer.layerName)
    case _ =>
      false
  }).toSet
}
