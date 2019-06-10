package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.{MissedInSpec, Origin}
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

	@MissedInSpec
	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap12.html#_Toc489946118")
	def realizes(dst: TechnologyServiceElement): T = tt._rel.realizes(dst)

	// лишнее ограничение уже есть в ElementRelationships
	// def associatedWith(dst: CommunicationNetworkElement): T = tt._rel.associatedWith(dst)

	_register(SystemSoftwareElement,
		JR.specializationOf(NodeElement),
		JR.assignedTo(SystemSoftwareElement),
		JR.realizes(TechnologyServiceElement),
		//		JR.associatedWith(CommunicationNetworkElement),
	)
}
