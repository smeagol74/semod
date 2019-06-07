package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait BusinessProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

case object BusinessProcessElement
	extends ElementName

trait BusinessProcessElementRelationships[T <: BusinessProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T] {

	_register(BusinessProcessElement)

}
