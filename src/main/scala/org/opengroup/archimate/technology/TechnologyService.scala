package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyServiceElement, TechnologyServiceElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyService(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyServiceElement {

	case class TechnologyServiceRelationships(
		override private[archimate] implicit val tt: TechnologyService = TechnologyService.this
	) extends TechnologyServiceElementRelationships[TechnologyService]

	val rel: TechnologyServiceRelationships = TechnologyServiceRelationships()

}
