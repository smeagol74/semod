package ru.kvb74.semod.opengroup.archimate.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element.strategy.{ResourceElement, ResourceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Strategy

case class Resource(
	name: String,
	desc: String = ""
) extends Strategy
	with ResourceElement {

	case class ResourceRelationships(
		override private[archimate] implicit val tt: Resource = Resource.this
	) extends ResourceElementRelationships[Resource]

	val rel: ResourceRelationships = ResourceRelationships()

}
