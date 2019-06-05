package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._

trait BusinessInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object BusinessInterfaceElement
	extends ElementName

trait BusinessInterfaceElementRelationships[T <: BusinessInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def assignedTo(dst: BusinessServiceElement): T = tt._rel.assignedTo(dst)

	_register(BusinessInterfaceElement,
		JR.serves(BusinessInternalActiveStructureElement),
		JR.assignedTo(BusinessServiceElement)
	)

}
