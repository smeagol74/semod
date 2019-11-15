package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait ImplementationLayer extends Layer {
  override def layerName = "Implementation"
}

case object ImplementationLayer extends ImplementationLayer