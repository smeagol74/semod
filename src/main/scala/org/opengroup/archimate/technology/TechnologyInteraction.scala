package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyInteractionElement, TechnologyInteractionElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyInteraction(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyInteractionElement {

	object rel extends TechnologyInteractionElementRelationships[TechnologyInteraction] {
		private[archimate] implicit val tt: TechnologyInteraction = TechnologyInteraction.this
	}

}
