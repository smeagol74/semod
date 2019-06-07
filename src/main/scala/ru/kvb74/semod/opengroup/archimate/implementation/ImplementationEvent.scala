package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{ImplementationEventElement, ImplementationEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Implementation

case class ImplementationEvent(
	name: String,
	desc: String = ""
) extends Implementation
	with ImplementationEventElement {

	case class ImplementationEventRelationships(
		private[archimate] implicit val tt: ImplementationEvent = ImplementationEvent.this
	) extends ImplementationEventElementRelationships[ImplementationEvent]

	val rel: ImplementationEventRelationships = ImplementationEventRelationships()

}
