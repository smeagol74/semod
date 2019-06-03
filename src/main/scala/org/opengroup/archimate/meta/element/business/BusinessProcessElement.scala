package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessProcessElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

trait BusinessProcessElementRelationships[T <: BusinessProcessElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T]
