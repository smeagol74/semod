package org.opengroup.archimate.strategy

import org.opengroup.archimate.meta.element.strategy.{CapabilityElement, CapabilityElementRelationships}
import org.opengroup.archimate.meta.layer.Strategy

case class Capability(
	name: String,
	desc: String = ""
) extends Strategy
	with CapabilityElement {

	case class CapabilityRelationships(
		override private[archimate] implicit val tt: Capability = Capability.this
	) extends CapabilityElementRelationships[Capability]

	val rel: CapabilityRelationships = CapabilityRelationships()

}
