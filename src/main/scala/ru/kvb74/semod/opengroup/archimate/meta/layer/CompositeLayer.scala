package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait CompositeLayer extends Layer {
  override def layerName = "Composite"
}

case object CompositeLayer extends CompositeLayer

