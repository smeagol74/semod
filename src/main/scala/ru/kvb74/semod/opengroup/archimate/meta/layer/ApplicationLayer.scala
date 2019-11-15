package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait ApplicationLayer extends Layer {
	override def layerName = "Application"
}
case object ApplicationLayer extends ApplicationLayer