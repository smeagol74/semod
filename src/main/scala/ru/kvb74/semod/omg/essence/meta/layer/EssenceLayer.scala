package ru.kvb74.semod.omg.essence.meta.layer

import ru.kvb74.semod.meta.Layer

trait EssenceLayer extends Layer {
	override def layerName = "Essence"
}
case object EssenceLayer extends EssenceLayer
