package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{ResourceElement, ResourceElementProps, ResourceElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Resource(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with ResourceElement {

	case class ResourceRelationships(
		override private[semod] implicit val tt: Resource = Resource.this
	) extends ResourceElementRelationships[Resource]

	val rel: ResourceRelationships = ResourceRelationships()

	case class ResourceProps(
		override private[semod] implicit val tt: Resource = Resource.this
	) extends ResourceElementProps[Resource]

	val prop: ResourceProps = ResourceProps()

	_registerPrefix("ER")

}

