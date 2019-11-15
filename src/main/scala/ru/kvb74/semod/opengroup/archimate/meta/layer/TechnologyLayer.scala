package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait TechnologyLayer extends Layer {
  override def layerName = "Technology"
}

case object TechnologyLayer extends TechnologyLayer

