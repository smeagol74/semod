package org.opengroup.archimate.business.composite

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.application.behavior.ApplicationService
import org.opengroup.archimate.application.structure.passive.DataObject
import org.opengroup.archimate.business.behavior.BusinessService
import org.opengroup.archimate.element.{CompositeElement, ElementRelationships, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessPassiveStructureElement}
import org.opengroup.archimate.technology.behavior.TechnologyService
import org.opengroup.archimate.technology.structure.passive.TechnologyObject

case class Product(
	name: String,
	desc: String = ""
) extends Business
	with CompositeElement {
	val id: String = IdGenerator.business.product

	object rel extends ElementRelationships[Product] {
		private[archimate] implicit val tt: Product = Product.this

		def aggregates(dst: BusinessPassiveStructureElement): Product = tt._rel.aggregates(dst)

		def isComposedOf(dst: BusinessPassiveStructureElement): Product = tt._rel.isComposedOf(dst)

		def aggregates(dst: DataObject): Product = tt._rel.aggregates(dst)

		def isComposedOf(dst: DataObject): Product = tt._rel.isComposedOf(dst)

		def aggregates(dst: TechnologyObject): Product = tt._rel.aggregates(dst)

		def isComposedOf(dst: TechnologyObject): Product = tt._rel.isComposedOf(dst)

		def aggregates(dst: BusinessService): Product = tt._rel.aggregates(dst)

		def isComposedOf(dst: BusinessService): Product = tt._rel.isComposedOf(dst)

		def aggregates(dst: ApplicationService): Product = tt._rel.aggregates(dst)

		def isComposedOf(dst: ApplicationService): Product = tt._rel.isComposedOf(dst)

		def aggregates(dst: TechnologyService): Product = tt._rel.aggregates(dst)

		def isComposedOf(dst: TechnologyService): Product = tt._rel.isComposedOf(dst)
	}

}
