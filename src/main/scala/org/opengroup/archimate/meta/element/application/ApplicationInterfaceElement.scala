package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._

trait ApplicationInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationInterfaceElement
	extends ElementName

trait ApplicationInterfaceElementRelationships[T <: ApplicationInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def assignedTo(dst: ApplicationServiceElement): T = tt._rel.assignedTo(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	_register(ApplicationInterfaceElement,
		JR.assignedTo(ApplicationServiceElement),
		JR.serves(ApplicationComponentElement),
	)

}