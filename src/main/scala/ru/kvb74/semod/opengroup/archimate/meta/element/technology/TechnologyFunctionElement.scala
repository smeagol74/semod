package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.ElementName
import ru.kvb74.semod.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementProps, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyFunctionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyInternalBehaviorElement

case object TechnologyFunctionElement
	extends ElementName

trait TechnologyFunctionElementProps[T <: TechnologyFunctionElement]
	extends StrategyCoreStructureBehaviorElementProps[T]
		with TechnologyInternalBehaviorElementProps[T]

trait TechnologyFunctionElementRelationships[T <: TechnologyFunctionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyInternalBehaviorElementRelationships[T] {

	_register(TechnologyFunctionElement)
	
}
