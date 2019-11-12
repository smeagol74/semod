package ru.kvb74.semod.meta

private[semod] trait ElementName {
	private[semod] def name = this match {
		case product: Product =>
			product.productPrefix.replace("Element", "")
		case _ => ""
	}
}
