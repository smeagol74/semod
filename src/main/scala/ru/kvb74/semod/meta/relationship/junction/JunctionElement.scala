package ru.kvb74.semod.meta.relationship.junction

import ru.kvb74.semod.meta.{Element, Layer}

trait Junction
	extends Layer {
	override val layerName = "Junction"
}

trait JunctionElement
	extends Element {
	override val name: String = ""
}
