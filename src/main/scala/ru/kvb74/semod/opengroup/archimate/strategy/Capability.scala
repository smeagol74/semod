package ru.kvb74.semod.opengroup.archimate.strategy

import ru.kvb74.semod.opengroup.archimate.meta.element.strategy.{CapabilityElement, CapabilityElementProps, CapabilityElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.StrategyLayer

case class Capability(
	name: String
) extends StrategyLayer
	with CapabilityElement {

	case class CapabilityRelationships(
		override private[semod] implicit val tt: Capability = Capability.this
	) extends CapabilityElementRelationships[Capability]

	val rel: CapabilityRelationships = CapabilityRelationships()

	case class CapabilityProps(
		override private[semod] implicit val tt: Capability = Capability.this
	) extends CapabilityElementProps[Capability]

	val prop: CapabilityProps = CapabilityProps()

	_registerPrefix("SC")
}
