package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyProcessElement, TechnologyProcessElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyProcess(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyProcessElement {

	case class TechnologyProcessRelationships(
		override private[archimate] implicit val tt: TechnologyProcess = TechnologyProcess.this
	) extends TechnologyProcessElementRelationships[TechnologyProcess]

	val rel: TechnologyProcessRelationships = TechnologyProcessRelationships()

}
