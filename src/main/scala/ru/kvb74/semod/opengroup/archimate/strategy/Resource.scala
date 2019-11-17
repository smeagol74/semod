package ru.kvb74.semod.opengroup.archimate.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element.strategy.{ResourceElement, ResourceElementProps, ResourceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.StrategyLayer

case class Resource(
	name: String
) extends StrategyLayer
	with ResourceElement {

	case class ResourceRelationships(
		override private[semod] implicit val tt: Resource = Resource.this
	) extends ResourceElementRelationships[Resource]

	val rel: ResourceRelationships = ResourceRelationships()

	case class ResourceProps(
		override private[semod] implicit val tt: Resource = Resource.this
	) extends ResourceElementProps[Resource]

	val prop: ResourceProps = ResourceProps()

	_registerPrefix("SR")
}
