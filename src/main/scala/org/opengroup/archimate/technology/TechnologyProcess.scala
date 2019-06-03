package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyProcessElement, TechnologyProcessElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyProcess(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyProcessElement {

	object rel extends TechnologyProcessElementRelationships[TechnologyProcess] {
		private[archimate] implicit val tt: TechnologyProcess = TechnologyProcess.this
	}

}
