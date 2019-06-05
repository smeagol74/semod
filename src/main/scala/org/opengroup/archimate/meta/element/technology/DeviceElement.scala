package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait DeviceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

case object DeviceElement
	extends ElementName

trait DeviceElementRelationships[T <: DeviceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {

	def assignedTo(dst: SystemSoftwareElement): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: CommunicationNetworkElement): T = tt._rel.associatedWith(dst)

	_register(DeviceElement,
		JR.assignedTo(SystemSoftwareElement),
		JR.associatedWith(CommunicationNetworkElement),
	)
}
