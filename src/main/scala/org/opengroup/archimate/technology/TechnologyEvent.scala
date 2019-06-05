package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyEventElement, TechnologyEventElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyEvent(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyEventElement {

	case class TechnologyEventRelationships(
		override private[archimate] implicit val tt: TechnologyEvent = TechnologyEvent.this
	) extends TechnologyEventElementRelationships[TechnologyEvent]

	val rel: TechnologyEventRelationships = TechnologyEventRelationships()

}
