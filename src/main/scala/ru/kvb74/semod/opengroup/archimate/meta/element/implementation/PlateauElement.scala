package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.Origin
import ru.kvb74.semod.opengroup.archimate.meta.element.business.ProductElement
import ru.kvb74.semod.opengroup.archimate.meta.element.composite.LocationElement
import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{GoalElement, RequirementElement}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.motivation.Requirement

trait PlateauElement
	extends Element

case object PlateauElement
	extends ElementName

trait PlateauElementRelationships[T <: PlateauElement]
	extends ElementRelationships[T] {

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: PlateauElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946120")
	def triggers(dst: ImplementationEventElement): T = tt._rel.triggers(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def aggregates(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.aggregates(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def composedOf(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.composedOf(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: StrategyCoreStructureBehaviorElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def aggregates(dst: ProductElement): T = tt._rel.aggregates(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def aggregates(dst: LocationElement): T = tt._rel.aggregates(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def composedOf(dst: ProductElement): T = tt._rel.composedOf(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def composedOf(dst: LocationElement): T = tt._rel.composedOf(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: ProductElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def realizes(dst: LocationElement): T = tt._rel.realizes(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def aggregates(dst: GoalElement): T = tt._rel.aggregates(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def aggregates(dst: RequirementElement): T = tt._rel.aggregates(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def composedOf(dst: GoalElement): T = tt._rel.composedOf(dst)

	@Origin("http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946130")
	def composedOf(dst: RequirementElement): T = tt._rel.composedOf(dst)

	_register(PlateauElement,
		JR.triggers(PlateauElement),
		JR.triggers(ImplementationEventElement),
		JR.aggregates(StrategyCoreStructureBehaviorElement),
		JR.composedOf(StrategyCoreStructureBehaviorElement),
		JR.realizes(StrategyCoreStructureBehaviorElement),
		JR.aggregates(ProductElement),
		JR.aggregates(LocationElement),
		JR.composedOf(ProductElement),
		JR.composedOf(LocationElement),
		JR.realizes(ProductElement),
		JR.realizes(LocationElement),
		JR.aggregates(GoalElement),
		JR.aggregates(RequirementElement),
		JR.composedOf(GoalElement),
		JR.composedOf(RequirementElement),
	)

}

