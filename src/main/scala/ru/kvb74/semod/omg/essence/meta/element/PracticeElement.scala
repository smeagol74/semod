package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait PracticeElement
	extends EssenceElement

case object PracticeElement
	extends ElementName

trait PracticeElementProps[T <: PracticeElement]
	extends EssenceElementProps[T]

trait PracticeElementRelationships[T <: PracticeElement]
	extends EssenceElementRelationships[T] {

	_register(PracticeElement)
}
