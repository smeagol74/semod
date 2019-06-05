package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._

trait BusinessRoleElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with BusinessInternalActiveStructureElement

case object BusinessRoleElement
	extends ElementName

trait BusinessRoleElementRelationships[T <: BusinessRoleElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with BusinessInternalActiveStructureElementRelationships[T] {

	_register(BusinessRoleElement)

}