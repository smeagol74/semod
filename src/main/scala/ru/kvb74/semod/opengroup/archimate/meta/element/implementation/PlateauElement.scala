package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait PlateauElement
	extends Element

case object PlateauElement
	extends ElementName

trait PlateauElementRelationships[T <: PlateauElement]
	extends ElementRelationships[T] {

	_register(PlateauElement)

}

