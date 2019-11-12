package ru.kvb74.semod.opengroup.archimate.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element.strategy.{CapabilityElement, CapabilityElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Strategy

case class Capability(
	name: String,
	desc: String = ""
) extends Strategy
	with CapabilityElement {

	case class CapabilityRelationships(
		override private[semod] implicit val tt: Capability = Capability.this
	) extends CapabilityElementRelationships[Capability]

	val rel: CapabilityRelationships = CapabilityRelationships()

	_registerPrefix("SC")
}
