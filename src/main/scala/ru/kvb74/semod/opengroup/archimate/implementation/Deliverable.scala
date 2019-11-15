package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{DeliverableElement, DeliverableElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class Deliverable(
	name: String,
	desc: String = ""
) extends ImplementationLayer
	with DeliverableElement {

	case class DeliverableRelationships(
		override private[semod] implicit val tt: Deliverable = Deliverable.this
	) extends DeliverableElementRelationships[Deliverable]

	val rel: DeliverableRelationships = DeliverableRelationships()

	_registerPrefix("ID")
}
