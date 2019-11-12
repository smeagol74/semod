package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

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

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: CommunicationNetworkElement): T = tt._rel.associatedWith(dst)

	_register(DeviceElement,
		RR.assignedTo(SystemSoftwareElement),
		//		JR.associatedWith(CommunicationNetworkElement),
	)
}
