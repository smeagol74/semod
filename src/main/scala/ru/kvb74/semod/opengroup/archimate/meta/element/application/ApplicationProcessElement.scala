package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait ApplicationProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with ApplicationInternalBehaviorElement

case object ApplicationProcessElement
	extends ElementName

trait ApplicationProcessElementProps[T <: ApplicationProcessElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with ApplicationInternalBehaviorElementProps[T]

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationProcessElementRelationships[T <: ApplicationProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with ApplicationInternalBehaviorElementRelationships[T] {

	_register(ApplicationProcessElement)
}