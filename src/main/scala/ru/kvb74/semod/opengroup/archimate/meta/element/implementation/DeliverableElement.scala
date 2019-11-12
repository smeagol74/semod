package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.Origin
import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.ProductElement
import ru.kvb74.semod.opengroup.archimate.meta.element.composite.LocationElement
import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.RequirementElement

trait DeliverableElement
	extends ArchimateElement

case object DeliverableElement
	extends ElementName

trait DeliverableElementRelationships[T <: DeliverableElement]
	extends ArchimateElementRelationships[T] {

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def realizes(dst: PlateauElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: ProductElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: LocationElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: RequirementElement): T = tt._rel.realizes(dst)

	_register(DeliverableElement,
		RR.realizes(PlateauElement),
		RR.realizes(StrategyCoreStructureBehaviorElement),
		RR.realizes(ProductElement),
		RR.realizes(LocationElement),
		RR.realizes(RequirementElement),
	)

}