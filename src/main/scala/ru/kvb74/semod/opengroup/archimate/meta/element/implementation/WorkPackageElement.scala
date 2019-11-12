package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.Origin
import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.ProductElement
import ru.kvb74.semod.opengroup.archimate.meta.element.composite.LocationElement

trait WorkPackageElement
	extends ArchimateElement

case object WorkPackageElement
	extends ElementName

trait WorkPackageElementRelationships[T <: WorkPackageElement]
	extends ArchimateElementRelationships[T] {

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
		RR.accesses(DeliverableElement),
		RR.realizes(DeliverableElement),
		RR.triggers(ImplementationEventElement),
		RR.flowsTo(ImplementationEventElement),
		RR.triggers(WorkPackageElement),
		RR.flowsTo(WorkPackageElement),
		RR.realizes(StrategyCoreStructureBehaviorElement),
		RR.realizes(ProductElement),
		RR.realizes(LocationElement),
	)

}
