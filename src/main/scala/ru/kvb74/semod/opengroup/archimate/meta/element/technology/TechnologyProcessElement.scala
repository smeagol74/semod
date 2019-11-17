package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementProps, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyInternalBehaviorElement

case object TechnologyProcessElement
	extends ElementName

trait TechnologyProcessElementProps[T <: TechnologyProcessElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with TechnologyInternalBehaviorElementProps[T]

trait TechnologyProcessElementRelationships[T <: TechnologyProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyInternalBehaviorElementRelationships[T] {

	_register(TechnologyProcessElement)

}
