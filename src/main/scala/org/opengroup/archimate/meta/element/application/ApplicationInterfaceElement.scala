package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.business.{BusinessInterfaceElement, BusinessInternalActiveStructureElement}
import org.opengroup.archimate.meta.element.technology.NodeElement

trait ApplicationInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationInterfaceElement
	extends ElementName

trait ApplicationInterfaceElementRelationships[T <: ApplicationInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def assignedTo(dst: ApplicationServiceElement): T = tt._rel.assignedTo(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def realizes(dst: BusinessInterfaceElement): T = tt._rel.realizes(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	_register(ApplicationInterfaceElement,
		JR.assignedTo(ApplicationServiceElement),
		JR.serves(ApplicationComponentElement),
		JR.serves(BusinessInternalActiveStructureElement),
		JR.realizes(BusinessInterfaceElement),
		JR.serves(NodeElement),
	)

}