package ru.kvb74.semod.meta.relationship.junction

private[semod] case class And()
	extends Junction
		with JunctionElement {
	_registerPrefix("JA")
}
