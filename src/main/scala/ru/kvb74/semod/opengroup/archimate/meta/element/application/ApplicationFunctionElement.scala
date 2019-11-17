package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait ApplicationFunctionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with ApplicationInternalBehaviorElement

case object ApplicationFunctionElement
	extends ElementName

trait ApplicationFunctionElementProps[T <: ApplicationFunctionElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with ApplicationInternalBehaviorElementProps[T]

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationFunctionElementRelationships[T <: ApplicationFunctionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with ApplicationInternalBehaviorElementRelationships[T] {

	_register(ApplicationFunctionElement)

}
