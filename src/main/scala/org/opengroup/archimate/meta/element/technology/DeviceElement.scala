package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait DeviceElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

trait DeviceElementRelationships[T <: DeviceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {
	def assignedTo(dst: SystemSoftwareElement): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: CommunicationNetworkElement): T = tt._rel.associatedWith(dst)
}
