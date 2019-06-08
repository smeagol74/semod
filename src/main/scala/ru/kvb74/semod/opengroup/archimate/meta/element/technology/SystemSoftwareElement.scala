package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait SystemSoftwareElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with NodeElement

case object SystemSoftwareElement
	extends ElementName

trait SystemSoftwareElementRelationships[T <: SystemSoftwareElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with NodeElementRelationships[T] {

	def specializationOf(dst: NodeElement): T = tt._rel.specializationOf(dst)

	def assignedTo(dst: SystemSoftwareElement): T = tt._rel.assignedTo(dst)

	// лишнее ограничение уже есть в ElementRelationships
	// def associatedWith(dst: CommunicationNetworkElement): T = tt._rel.associatedWith(dst)

	_register(SystemSoftwareElement,
		JR.specializationOf(NodeElement),
		JR.assignedTo(SystemSoftwareElement),
		//		JR.associatedWith(CommunicationNetworkElement),
	)
}
