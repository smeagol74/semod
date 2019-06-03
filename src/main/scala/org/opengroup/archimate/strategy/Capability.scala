package org.opengroup.archimate.strategy

import org.opengroup.archimate.meta.element.strategy.{CapabilityElement, CapabilityElementRelationships}
import org.opengroup.archimate.meta.layer.Strategy

case class Capability(
	name: String,
	desc: String = ""
) extends Strategy
	with CapabilityElement {

	object rel extends CapabilityElementRelationships[Capability] {
		override private[archimate] implicit val tt: Capability = Capability.this
	}

}
