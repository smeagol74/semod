package org.opengroup.archimate.strategy

import org.opengroup.archimate.meta.element.strategy.{ResourceElement, ResourceElementRelationships}
import org.opengroup.archimate.meta.layer.Strategy

case class Resource(
	name: String,
	desc: String = ""
) extends Strategy
	with ResourceElement {

	object rel extends ResourceElementRelationships[Resource] {
		override private[archimate] implicit val tt: Resource = Resource.this
	}

}
