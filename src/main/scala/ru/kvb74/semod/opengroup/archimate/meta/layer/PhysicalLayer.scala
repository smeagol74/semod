package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait PhysicalLayer extends Layer {
  override def layerName = "Physical"
}

case object PhysicalLayer extends PhysicalLayer