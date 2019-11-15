package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait StrategyLayer extends Layer {
  override def layerName = "Strategy"
}

case object StrategyLayer extends StrategyLayer
