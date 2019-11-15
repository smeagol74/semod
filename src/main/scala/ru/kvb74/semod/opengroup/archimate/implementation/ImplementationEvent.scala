package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{ImplementationEventElement, ImplementationEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class ImplementationEvent(
	name: String,
	desc: String = ""
) extends ImplementationLayer
	with ImplementationEventElement {

	case class ImplementationEventRelationships(
		override private[semod] implicit val tt: ImplementationEvent = ImplementationEvent.this
	) extends ImplementationEventElementRelationships[ImplementationEvent]

	val rel: ImplementationEventRelationships = ImplementationEventRelationships()

	_registerPrefix("IE")
}
