package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait CommunicationNetworkElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object CommunicationNetworkElement
	extends ElementName

trait CommunicationNetworkElementRelationships[T <: CommunicationNetworkElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: PathElement): T = tt._rel.realizes(dst)

	def associatedWith(dst: DeviceElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: DeviceElement): T = tt._rel.aggregates(dst)

	def associatedWith(dst: SystemSoftwareElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: SystemSoftwareElement): T = tt._rel.aggregates(dst)

	_register(CommunicationNetworkElement,
		JR.realizes(PathElement),
		JR.associatedWith(DeviceElement),
		JR.aggregates(DeviceElement),
		JR.associatedWith(SystemSoftwareElement),
		JR.aggregates(SystemSoftwareElement),
	)
}

