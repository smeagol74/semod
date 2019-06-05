package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.application.{ApplicationServiceElement, DataObjectElement}
import org.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyServiceElement}

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
		JR.aggregates(BusinessPassiveStructureElement),
		JR.composedOf(BusinessPassiveStructureElement),
		JR.aggregates(DataObjectElement),
		JR.composedOf(DataObjectElement),
		JR.aggregates(TechnologyObjectElement),
		JR.composedOf(TechnologyObjectElement),
		JR.aggregates(BusinessServiceElement),
		JR.composedOf(BusinessServiceElement),
		JR.aggregates(ApplicationServiceElement),
		JR.composedOf(ApplicationServiceElement),
		JR.aggregates(TechnologyServiceElement),
		JR.composedOf(TechnologyServiceElement),
	)

}