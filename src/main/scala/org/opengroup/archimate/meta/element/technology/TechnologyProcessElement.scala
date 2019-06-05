package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{BehaviorElement, ElementName, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyInternalBehaviorElement

case object TechnologyProcessElement
	extends ElementName

trait TechnologyProcessElementRelationships[T <: TechnologyProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyInternalBehaviorElementRelationships[T] {

	_register(TechnologyProcessElement)

}
