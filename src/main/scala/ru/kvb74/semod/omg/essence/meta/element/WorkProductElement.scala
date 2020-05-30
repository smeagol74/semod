package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.meta.ElementName

trait WorkProductElement	
	extends EssenceElement

case object WorkProductElement
	extends ElementName

trait WorkProductElementProps[T <: WorkProductElement]
	extends EssenceElementProps[T]

trait WorkProductElementRelationships[T <: WorkProductElement]
	extends EssenceElementRelationships[T] {

	_register(WorkProductElement)
}

