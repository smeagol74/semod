package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{RepresentationElement, RepresentationElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class Representation(
	name: String,
	desc: String = ""
) extends Business
	with RepresentationElement {

	object rel extends RepresentationElementRelationships[Representation] {
		override private[archimate] implicit val tt: Representation = Representation.this
	}

}
