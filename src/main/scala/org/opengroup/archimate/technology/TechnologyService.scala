package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyServiceElement, TechnologyServiceElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyService(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyServiceElement {

	object rel extends TechnologyServiceElementRelationships[TechnologyService] {
		private[archimate] implicit val tt: TechnologyService = TechnologyService.this
	}

}
