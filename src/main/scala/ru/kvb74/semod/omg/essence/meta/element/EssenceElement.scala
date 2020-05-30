package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.{Element, ElementName, ElementProps, ElementRelationships, RR}
import ru.kvb74.semod.omg.essence.meta.layer.AreaOfConcern

trait EssenceElement
	extends Element {
	val areaOfConcern: AreaOfConcern.Value
}

case object EssenceElement
	extends ElementName

trait EssenceElementProps[T <: EssenceElement]
	extends ElementProps[T]

trait EssenceElementRelationships[T <: EssenceElement]
	extends ElementRelationships[T] {

	_register(EssenceElement)
}
