package ru.kvb74.semod.system.meta.layer

import ru.kvb74.semod.meta.Layer

trait SystemLayer extends Layer {
  override def layerName = "System"
}
case object SystemLayer extends SystemLayer