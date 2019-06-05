package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._

trait BusinessInteractionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalBehaviorElement

case object BusinessInteractionElement
	extends ElementName

trait BusinessInteractionElementRelationships[T <: BusinessInteractionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalBehaviorElementRelationships[T] {

	_register(BusinessInteractionElement)

}