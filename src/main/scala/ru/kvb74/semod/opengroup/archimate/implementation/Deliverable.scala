package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{DeliverableElement, DeliverableElementProps, DeliverableElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class Deliverable(
	name: String
) extends ImplementationLayer
	with DeliverableElement {

	case class DeliverableRelationships(
		override private[semod] implicit val tt: Deliverable = Deliverable.this
	) extends DeliverableElementRelationships[Deliverable]

	val rel: DeliverableRelationships = DeliverableRelationships()

	case class DeliverableProps(
		override private[semod] implicit val tt: Deliverable = Deliverable.this
	) extends DeliverableElementProps[Deliverable]

	val prop: DeliverableProps = DeliverableProps()

	_registerPrefix("ID")
}
