package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyInterfaceElement, TechnologyInterfaceElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyInterface(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyInterfaceElement {

	case class TechnologyInterfaceRelationships(
		override private[archimate] implicit val tt: TechnologyInterface = TechnologyInterface.this
	) extends TechnologyInterfaceElementRelationships[TechnologyInterface]

	val rel: TechnologyInterfaceRelationships = TechnologyInterfaceRelationships()

}
