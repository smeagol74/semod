package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.{MissedInSpec, Origin}
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

	@MissedInSpec
	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap12.html#_Toc489946118")
	def accesses(dst: DataObjectElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	_register(ApplicationComponentElement,
		RR.composedOf(ApplicationInterfaceElement),
		RR.assignedTo(ApplicationInternalBehaviorElement),
		RR.assignedTo(ApplicationEventElement),
		RR.realizes(ApplicationComponentElement),
		RR.accesses(DataObjectElement),
	)
}
