package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessInteractionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

case object BusinessInteractionElement
	extends ElementName

trait BusinessInteractionElementProps[T <: BusinessInteractionElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with BusinessInternalBehaviorElementProps[T]

trait BusinessInteractionElementRelationships[T <: BusinessInteractionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T] {

	_register(BusinessInteractionElement)

}