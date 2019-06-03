package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyEventElement, TechnologyEventElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyEvent(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyEventElement {

	object rel extends TechnologyEventElementRelationships[TechnologyEvent] {
		private[archimate] implicit val tt: TechnologyEvent = TechnologyEvent.this
	}

}
