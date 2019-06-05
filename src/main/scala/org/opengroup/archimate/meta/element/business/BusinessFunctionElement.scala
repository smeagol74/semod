package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._

trait BusinessFunctionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

case object BusinessFunctionElement
	extends ElementName

trait BusinessFunctionElementRelationships[T <: BusinessFunctionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T] {

	_register(BusinessFunctionElement)

}