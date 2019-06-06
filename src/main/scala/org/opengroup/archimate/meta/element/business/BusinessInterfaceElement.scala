package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.application.ApplicationComponentElement
import org.opengroup.archimate.meta.element.technology.NodeElement

trait BusinessInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object BusinessInterfaceElement
	extends ElementName

trait BusinessInterfaceElementRelationships[T <: BusinessInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def assignedTo(dst: BusinessServiceElement): T = tt._rel.assignedTo(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	_register(BusinessInterfaceElement,
		JR.serves(BusinessInternalActiveStructureElement),
		JR.assignedTo(BusinessServiceElement),
		JR.serves(ApplicationComponentElement),
		JR.serves(NodeElement),
	)

}
