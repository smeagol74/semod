package ru.kvb74.semod.opengroup.archimate.meta.layer

import ru.kvb74.semod.meta.Layer

trait BusinessLayer extends Layer {
	override def layerName = "Business"
}

case object BusinessLayer extends BusinessLayer

