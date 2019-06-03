package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyFunctionElement, TechnologyFunctionElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyFunction(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyFunctionElement {

	object rel extends TechnologyFunctionElementRelationships[TechnologyFunction] {
		private[archimate] implicit val tt: TechnologyFunction = TechnologyFunction.this
	}

}
