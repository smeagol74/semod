package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.{BehaviorElement, ElementName, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyInteractionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyInternalBehaviorElement

case object TechnologyInteractionElement
	extends ElementName

trait TechnologyInteractionElementRelationships[T <: TechnologyInteractionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyInternalBehaviorElementRelationships[T] {

	_register(TechnologyInteractionElement)

}
