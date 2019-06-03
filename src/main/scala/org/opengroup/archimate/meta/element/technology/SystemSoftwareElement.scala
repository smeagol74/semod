package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait SystemSoftwareElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

trait SystemSoftwareElementRelationships[T <: SystemSoftwareElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {
	def isSpecializationOf(dst: NodeElement): T = tt._rel.isSpecializationOf(dst)

	def assignedTo(dst: SystemSoftwareElement): T = tt._rel.assignedTo(dst)

	def associatedWith(dst: CommunicationNetworkElement): T = tt._rel.associatedWith(dst)

}
