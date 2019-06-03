package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.technology.{Device, Path, SystemSoftware}

trait CommunicationNetworkElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait CommunicationNetworkElementRelationships[T <: CommunicationNetworkElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def realizes(dst: Path): T = tt._rel.realizes(dst)

	def associatedWith(dst: Device): T = tt._rel.associatedWith(dst)

	def aggregates(dst: Device): T = tt._rel.aggregates(dst)

	def associatedWith(dst: SystemSoftware): T = tt._rel.associatedWith(dst)

	def aggregates(dst: SystemSoftware): T = tt._rel.aggregates(dst)
}

