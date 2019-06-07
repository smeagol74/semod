package ru.kvb74.semod.opengroup.archimate.meta.relationship

import ru.kvb74.semod.opengroup.archimate.meta.element.Element

trait Relationship {
	val src: Element
	val dst: Element
	val direct: Boolean

	def reverse: Relationship = this
}
