package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyObjectElement, TechnologyObjectElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyObject(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyObjectElement {

	object rel extends TechnologyObjectElementRelationships[TechnologyObject] {
		private[archimate] implicit val tt: TechnologyObject = TechnologyObject.this
	}

}
