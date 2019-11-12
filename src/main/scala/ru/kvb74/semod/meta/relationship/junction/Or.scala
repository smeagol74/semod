package ru.kvb74.semod.meta.relationship.junction

private[semod] case class Or()
	extends Junction
		with JunctionElement {
	_registerPrefix("JO")
}
