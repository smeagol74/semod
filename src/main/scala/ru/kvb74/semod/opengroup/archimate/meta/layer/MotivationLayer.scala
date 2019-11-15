package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait MotivationLayer extends Layer {
	override def layerName = "Motivation"
}

case object MotivationLayer extends MotivationLayer
