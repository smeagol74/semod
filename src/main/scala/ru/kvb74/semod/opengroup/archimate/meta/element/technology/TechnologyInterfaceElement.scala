package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationInterfaceElement}
import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessInterfaceElement, BusinessInternalActiveStructureElement}

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

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)
	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)
	def realizes(dst: BusinessInterfaceElement): T = tt._rel.realizes(dst)
	def realizes(dst: ApplicationInterfaceElement): T = tt._rel.realizes(dst)

	_register(TechnologyInterfaceElement,
		JR.assignedTo(TechnologyServiceElement),
		JR.serves(NodeElement),
		JR.serves(SystemSoftwareElement),
		JR.serves(DeviceElement),
		JR.serves(TechnologyCollaborationElement),
		JR.serves(BusinessInternalActiveStructureElement),
		JR.serves(ApplicationComponentElement),
		JR.realizes(BusinessInterfaceElement),
		JR.realizes(ApplicationInterfaceElement),
	)
}
