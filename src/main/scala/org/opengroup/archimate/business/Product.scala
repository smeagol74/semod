package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{ProductElement, ProductElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class Product(
	name: String,
	desc: String = ""
) extends Business
	with ProductElement {

	object rel extends ProductElementRelationships[Product] {
		override private[archimate] implicit val tt: Product = Product.this
	}

}
