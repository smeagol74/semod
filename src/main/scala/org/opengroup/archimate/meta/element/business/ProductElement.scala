package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.application.{ApplicationServiceElement, DataObjectElement}
import org.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyServiceElement}
import org.opengroup.archimate.meta.element.{CompositeElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ProductElement
	extends CompositeElement
		with StrategyCoreStructureBehaviorElement

trait ProductElementRelationships[T <: ProductElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def aggregates(dst: BusinessPassiveStructureElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: BusinessPassiveStructureElement): T = tt._rel.isComposedOf(dst)

	def aggregates(dst: DataObjectElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: DataObjectElement): T = tt._rel.isComposedOf(dst)

	def aggregates(dst: TechnologyObjectElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: TechnologyObjectElement): T = tt._rel.isComposedOf(dst)

	def aggregates(dst: BusinessServiceElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: BusinessServiceElement): T = tt._rel.isComposedOf(dst)

	def aggregates(dst: ApplicationServiceElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: ApplicationServiceElement): T = tt._rel.isComposedOf(dst)

	def aggregates(dst: TechnologyServiceElement): T = tt._rel.aggregates(dst)

	def isComposedOf(dst: TechnologyServiceElement): T = tt._rel.isComposedOf(dst)

}