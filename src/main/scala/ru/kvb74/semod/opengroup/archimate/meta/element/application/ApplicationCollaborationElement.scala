package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait ApplicationCollaborationElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationCollaborationElement
	extends ElementName

trait ApplicationCollaborationElementRelationships[T <: ApplicationCollaborationElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def composedOf(dst: ApplicationInterfaceElement): T = tt._rel.composedOf(dst)

	def assignedTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: ApplicationEventElement): T = tt._rel.assignedTo(dst)

	def realizes(dst: ApplicationComponentElement): T = tt._rel.realizes(dst)

	def aggregates(dst: ApplicationComponentElement): T = tt._rel.aggregates(dst)

	def specializationOf(dst: ApplicationComponentElement): T = tt._rel.specializationOf(dst)

	_register(ApplicationCollaborationElement,
		RR.composedOf(ApplicationInterfaceElement),
		RR.assignedTo(ApplicationInternalBehaviorElement),
		RR.assignedTo(ApplicationEventElement),
		RR.realizes(ApplicationComponentElement),
		RR.aggregates(ApplicationComponentElement),
		RR.specializationOf(ApplicationComponentElement),
	)
}