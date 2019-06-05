package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyFunctionElement, TechnologyFunctionElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyFunction(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyFunctionElement {

	case class TechnologyFunctionRelationships(
		override private[archimate] implicit val tt: TechnologyFunction = TechnologyFunction.this
	) extends TechnologyFunctionElementRelationships[TechnologyFunction]

	val rel: TechnologyFunctionRelationships = TechnologyFunctionRelationships()

}
