package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.Origin
import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ArchimateElement, ArchimateElementProps, ArchimateElementRelationships}

trait ImplementationEventElement
	extends ArchimateElement

case object ImplementationEventElement
	extends ElementName

trait ImplementationEventElementProps[T <: ImplementationEventElement]
	extends ArchimateElementProps[T]

trait ImplementationEventElementRelationships[T <: ImplementationEventElement]
	extends ArchimateElementRelationships[T] {

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: WorkPackageElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def flowsTo(dst: WorkPackageElement, label: String): T = tt._rel.flowsTo(dst, label)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def accesses(dst: DeliverableElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: PlateauElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: ImplementationEventElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def flowsTo(dst: ImplementationEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	_register(ImplementationEventElement,
		RR.triggers(WorkPackageElement),
		RR.flowsTo(WorkPackageElement),
		RR.accesses(DeliverableElement),
		RR.triggers(PlateauElement),
		RR.triggers(ImplementationEventElement),
		RR.flowsTo(ImplementationEventElement),
	)

}
