package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.opengroup.archimate.meta.element._

trait ApplicationComponentElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object ApplicationComponentElement
	extends ElementName

trait ApplicationComponentElementRelationships[T <: ApplicationComponentElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def composedOf(dst: ApplicationInterfaceElement): T = tt._rel.composedOf(dst)

	def assignedTo(dst: ApplicationInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: ApplicationEventElement): T = tt._rel.assignedTo(dst)

	def realizes(dst: ApplicationComponentElement): T = tt._rel.realizes(dst)

	_register(ApplicationComponentElement,
		JR.composedOf(ApplicationInterfaceElement),
		JR.assignedTo(ApplicationInternalBehaviorElement),
		JR.assignedTo(ApplicationEventElement),
		JR.realizes(ApplicationComponentElement),
	)
}
