package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait CompetencyElement
	extends EssenceElement

case object CompetencyElement
	extends ElementName

trait CompetencyElementProps[T <: CompetencyElement]
	extends EssenceElementProps[T]

trait CompetencyElementRelationships[T <: CompetencyElement]
	extends EssenceElementRelationships[T] {

	_register(CompetencyElement)
}

