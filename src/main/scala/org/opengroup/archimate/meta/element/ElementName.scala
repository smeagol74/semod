package org.opengroup.archimate.meta.element

private[archimate] trait ElementName {
	private[archimate] def name = this match {
		case product: Product =>
			product.productPrefix.replace("Element", "")
		case _ => ""
	}
}
