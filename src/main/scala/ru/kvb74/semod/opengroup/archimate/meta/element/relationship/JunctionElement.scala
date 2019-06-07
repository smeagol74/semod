package ru.kvb74.semod.opengroup.archimate.meta.element.relationship

import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.opengroup.archimate.meta.layer.Layer

trait Junction
	extends Layer {
	override val layerName = "Junction"
}

trait JunctionElement
	extends Element {
	override val name: String = ""
	override val desc: String = ""
}
