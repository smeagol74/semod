package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{ImplementationEventElement, ImplementationEventElementProps, ImplementationEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class ImplementationEvent(
	name: String
) extends ImplementationLayer
	with ImplementationEventElement {

	case class ImplementationEventRelationships(
		override private[semod] implicit val tt: ImplementationEvent = ImplementationEvent.this
	) extends ImplementationEventElementRelationships[ImplementationEvent]

	val rel: ImplementationEventRelationships = ImplementationEventRelationships()

	case class ImplementationEventProps(
		override private[semod] implicit val tt: ImplementationEvent = ImplementationEvent.this
	) extends ImplementationEventElementProps[ImplementationEvent]

	val prop: ImplementationEventProps = ImplementationEventProps()

	_registerPrefix("IE")
}
