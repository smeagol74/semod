package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessEventElement, BusinessEventElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessEvent(
	name: String,
	desc: String = ""
) extends Business
	with BusinessEventElement {

	case class BusinessEventRelationships(
		override private[archimate] implicit val tt: BusinessEvent = BusinessEvent.this
	) extends BusinessEventElementRelationships[BusinessEvent]

	val rel: BusinessEventRelationships = BusinessEventRelationships()

}
