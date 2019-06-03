package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyInterfaceElement, TechnologyInterfaceElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyInterface(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyInterfaceElement {

	object rel extends TechnologyInterfaceElementRelationships[TechnologyInterface] {
		private[archimate] implicit val tt: TechnologyInterface = TechnologyInterface.this
	}

}
