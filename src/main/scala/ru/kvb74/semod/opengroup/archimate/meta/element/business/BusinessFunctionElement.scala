package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessFunctionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

case object BusinessFunctionElement
	extends ElementName

trait BusinessFunctionElementProps[T <: BusinessFunctionElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with BusinessInternalBehaviorElementProps[T]

trait BusinessFunctionElementRelationships[T <: BusinessFunctionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T] {

	_register(BusinessFunctionElement)

}