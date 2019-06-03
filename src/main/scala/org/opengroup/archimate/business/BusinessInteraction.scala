package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessInteractionElement, BusinessInteractionElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessInteraction(
	name: String,
	desc: String = ""
) extends Business
	with BusinessInteractionElement {

	object rel extends BusinessInteractionElementRelationships[BusinessInteraction] {
		override private[archimate] implicit val tt: BusinessInteraction = BusinessInteraction.this
	}

}
