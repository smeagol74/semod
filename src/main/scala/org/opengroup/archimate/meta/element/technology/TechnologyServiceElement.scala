package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationInternalBehaviorElement, ApplicationServiceElement}
import org.opengroup.archimate.meta.element.business.{BusinessInternalActiveStructureElement, BusinessInternalBehaviorElement, BusinessServiceElement}
import org.opengroup.archimate.relationship.dependency.AccessMode

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
		JR.triggers(TechnologyServiceElement),
		JR.flowsTo(TechnologyServiceElement),
		JR.triggers(TechnologyEventElement),
		JR.flowsTo(TechnologyEventElement),
		JR.accesses(TechnologyObjectElement),
		JR.accesses(ArtifactElement),
		JR.serves(TechnologyInternalBehaviorElement),
		JR.serves(NodeElement),
		JR.serves(SystemSoftwareElement),
		JR.serves(DeviceElement),
		JR.serves(TechnologyCollaborationElement),
		JR.serves(ApplicationInternalBehaviorElement),
		JR.serves(ApplicationComponentElement),
		JR.serves(BusinessInternalBehaviorElement),
		JR.serves(BusinessInternalActiveStructureElement),
		JR.realizes(BusinessServiceElement),
		JR.realizes(ApplicationServiceElement),
	)
}
