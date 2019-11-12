package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationInternalBehaviorElement, ApplicationServiceElement}
import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessInternalActiveStructureElement, BusinessInternalBehaviorElement, BusinessServiceElement}

trait TechnologyServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyServiceElement
	extends ElementName

trait TechnologyServiceElementRelationships[T <: TechnologyServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: TechnologyServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyServiceElement, label: String): T = tt._rel.flowsTo(dst, label)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	def accesses(dst: TechnologyObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def accesses(dst: ArtifactElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	def serves(dst: TechnologyInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	def serves(dst: SystemSoftwareElement): T = tt._rel.serves(dst)

	def serves(dst: DeviceElement): T = tt._rel.serves(dst)

	def serves(dst: TechnologyCollaborationElement): T = tt._rel.serves(dst)

	def serves(dst: ApplicationInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: ApplicationComponentElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: BusinessInternalActiveStructureElement): T = tt._rel.serves(dst)

	def realizes(dst: BusinessServiceElement): T = tt._rel.realizes(dst)

	def realizes(dst: ApplicationServiceElement): T = tt._rel.realizes(dst)

	_register(TechnologyServiceElement,
		RR.triggers(TechnologyServiceElement),
		RR.flowsTo(TechnologyServiceElement),
		RR.triggers(TechnologyEventElement),
		RR.flowsTo(TechnologyEventElement),
		RR.accesses(TechnologyObjectElement),
		RR.accesses(ArtifactElement),
		RR.serves(TechnologyInternalBehaviorElement),
		RR.serves(NodeElement),
		RR.serves(SystemSoftwareElement),
		RR.serves(DeviceElement),
		RR.serves(TechnologyCollaborationElement),
		RR.serves(ApplicationInternalBehaviorElement),
		RR.serves(ApplicationComponentElement),
		RR.serves(BusinessInternalBehaviorElement),
		RR.serves(BusinessInternalActiveStructureElement),
		RR.realizes(BusinessServiceElement),
		RR.realizes(ApplicationServiceElement),
	)
}
