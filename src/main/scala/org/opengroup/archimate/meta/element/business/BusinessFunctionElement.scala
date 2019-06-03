package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait BusinessFunctionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

trait BusinessFunctionElementRelationships[T <: BusinessFunctionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T]