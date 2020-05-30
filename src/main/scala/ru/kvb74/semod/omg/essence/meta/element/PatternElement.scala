package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait PatternElement
	extends EssenceElement

case object PatternElement
	extends ElementName

trait PatternElementProps[T <: PatternElement]
	extends EssenceElementProps[T]

trait PatternElementRelationships[T <: PatternElement]
	extends EssenceElementRelationships[T] {

	_register(PatternElement)
}

