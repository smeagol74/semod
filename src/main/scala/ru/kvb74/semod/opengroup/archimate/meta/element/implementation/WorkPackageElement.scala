package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.Origin
import ru.kvb74.semod.opengroup.archimate.meta.element.business.ProductElement
import ru.kvb74.semod.opengroup.archimate.meta.element.composite.LocationElement
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode

trait WorkPackageElement
	extends Element

case object WorkPackageElement
	extends ElementName

trait WorkPackageElementRelationships[T <: WorkPackageElement]
	extends ElementRelationships[T] {

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def accesses(dst: DeliverableElement, mode: AccessMode.Value): T = tt._rel.accesses(dst, mode)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def realizes(dst: DeliverableElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: ImplementationEventElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def flowsTo(dst: ImplementationEventElement, label: String): T = tt._rel.flowsTo(dst, label)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: WorkPackageElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def flowsTo(dst: WorkPackageElement, label: String): T = tt._rel.flowsTo(dst, label)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: ProductElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: LocationElement): T = tt._rel.realizes(dst)

	_register(WorkPackageElement,
		JR.accesses(DeliverableElement),
		JR.realizes(DeliverableElement),
		JR.triggers(ImplementationEventElement),
		JR.flowsTo(ImplementationEventElement),
		JR.triggers(WorkPackageElement),
		JR.flowsTo(WorkPackageElement),
		JR.realizes(StrategyCoreStructureBehaviorElement),
		JR.realizes(ProductElement),
		JR.realizes(LocationElement),
	)

}
