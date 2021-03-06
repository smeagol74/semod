package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

case object BusinessProcessElement
	extends ElementName

trait BusinessProcessElementProps[T <: BusinessProcessElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with BusinessInternalBehaviorElementProps[T] 

trait BusinessProcessElementRelationships[T <: BusinessProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T] {

	_register(BusinessProcessElement)

}
