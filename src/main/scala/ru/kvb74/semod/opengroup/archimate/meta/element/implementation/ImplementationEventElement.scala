package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.Origin
import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships, JR}
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait ImplementationEventElement
	extends Element

case object ImplementationEventElement
	extends ElementName

trait ImplementationEventElementRelationships[T <: ImplementationEventElement]
	extends ElementRelationships[T] {

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
		JR.triggers(WorkPackageElement),
		JR.flowsTo(WorkPackageElement),
		JR.accesses(DeliverableElement),
		JR.triggers(PlateauElement),
		JR.triggers(ImplementationEventElement),
		JR.flowsTo(ImplementationEventElement),
	)

}
