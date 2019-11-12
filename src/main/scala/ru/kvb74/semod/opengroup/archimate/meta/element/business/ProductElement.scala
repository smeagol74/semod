package ru.kvb74.semod.opengroup.archimate.meta.element.business

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationServiceElement, DataObjectElement}
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyServiceElement}

trait ProductElement
	extends CompositeElement
		with StrategyCoreStructureBehaviorElement

case object ProductElement
	extends ElementName

trait ProductElementRelationships[T <: ProductElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def aggregates(dst: BusinessPassiveStructureElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: BusinessPassiveStructureElement): T = tt._rel.composedOf(dst)

	def aggregates(dst: DataObjectElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: DataObjectElement): T = tt._rel.composedOf(dst)

	def aggregates(dst: TechnologyObjectElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: TechnologyObjectElement): T = tt._rel.composedOf(dst)

	def aggregates(dst: BusinessServiceElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: BusinessServiceElement): T = tt._rel.composedOf(dst)

	def aggregates(dst: ApplicationServiceElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: ApplicationServiceElement): T = tt._rel.composedOf(dst)

	def aggregates(dst: TechnologyServiceElement): T = tt._rel.aggregates(dst)

	def composedOf(dst: TechnologyServiceElement): T = tt._rel.composedOf(dst)

	_register(ProductElement,
		RR.aggregates(BusinessPassiveStructureElement),
		RR.composedOf(BusinessPassiveStructureElement),
		RR.aggregates(DataObjectElement),
		RR.composedOf(DataObjectElement),
		RR.aggregates(TechnologyObjectElement),
		RR.composedOf(TechnologyObjectElement),
		RR.aggregates(BusinessServiceElement),
		RR.composedOf(BusinessServiceElement),
		RR.aggregates(ApplicationServiceElement),
		RR.composedOf(ApplicationServiceElement),
		RR.aggregates(TechnologyServiceElement),
		RR.composedOf(TechnologyServiceElement),
	)

}