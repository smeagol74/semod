package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{PlaceholderElement, PlaceholderElementProps, PlaceholderElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class Placeholder(
	name: String
) extends SystemLayer
	with PlaceholderElement {

	case class PlaceholderRelationships(
		override private[semod] implicit val tt: Placeholder = Placeholder.this
	) extends PlaceholderElementRelationships[Placeholder]

	val rel: PlaceholderRelationships = PlaceholderRelationships()

	case class PlaceholderProps(
		override private[semod] implicit val tt: Placeholder = Placeholder.this
	) extends PlaceholderElementProps[Placeholder]

	val prop: PlaceholderProps = PlaceholderProps()

	_registerPrefix("SP")
}
