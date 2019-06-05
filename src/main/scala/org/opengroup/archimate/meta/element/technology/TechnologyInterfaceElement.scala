package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait TechnologyInterfaceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyInterfaceElement
	extends ElementName

trait TechnologyInterfaceElementRelationships[T <: TechnologyInterfaceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def assignedTo(dst: TechnologyServiceElement): T = tt._rel.assignedTo(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	def serves(dst: SystemSoftwareElement): T = tt._rel.serves(dst)

	def serves(dst: DeviceElement): T = tt._rel.serves(dst)

	def serves(dst: TechnologyCollaborationElement): T = tt._rel.serves(dst)

	_register(TechnologyInterfaceElement,
		JR.assignedTo(TechnologyServiceElement),
		JR.serves(NodeElement),
		JR.serves(SystemSoftwareElement),
		JR.serves(DeviceElement),
		JR.serves(TechnologyCollaborationElement),
	)
}
