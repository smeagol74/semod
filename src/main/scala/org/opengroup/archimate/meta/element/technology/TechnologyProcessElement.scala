package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait TechnologyProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyInternalBehaviorElement

trait TechnologyProcessElementRelationships[T <: TechnologyProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyInternalBehaviorElementRelationships[T]
