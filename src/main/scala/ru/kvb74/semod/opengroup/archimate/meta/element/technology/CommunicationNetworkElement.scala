package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait CommunicationNetworkElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object CommunicationNetworkElement
	extends ElementName

trait CommunicationNetworkElementProps[T <: CommunicationNetworkElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

trait CommunicationNetworkElementRelationships[T <: CommunicationNetworkElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: PathElement): T = tt._rel.realizes(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: DeviceElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: DeviceElement): T = tt._rel.aggregates(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: SystemSoftwareElement): T = tt._rel.associatedWith(dst)

	def aggregates(dst: SystemSoftwareElement): T = tt._rel.aggregates(dst)

	_register(CommunicationNetworkElement,
		RR.realizes(PathElement),
		//		JR.associatedWith(DeviceElement),
		RR.aggregates(DeviceElement),
		//		JR.associatedWith(SystemSoftwareElement),
		RR.aggregates(SystemSoftwareElement),
	)
}

