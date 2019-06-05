package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessInteractionElement, BusinessInteractionElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessInteraction(
	name: String,
	desc: String = ""
) extends Business
	with BusinessInteractionElement {

	case class BusinessInteractionRelationships(
		override private[archimate] implicit val tt: BusinessInteraction = BusinessInteraction.this
	) extends BusinessInteractionElementRelationships[BusinessInteraction]

	val rel: BusinessInteractionRelationships = BusinessInteractionRelationships()

}
