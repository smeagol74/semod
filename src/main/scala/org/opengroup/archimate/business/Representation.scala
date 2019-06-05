package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{RepresentationElement, RepresentationElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class Representation(
	name: String,
	desc: String = ""
) extends Business
	with RepresentationElement {

	case class RepresentationRelationships(
		override private[archimate] implicit val tt: Representation = Representation.this
	) extends RepresentationElementRelationships[Representation]

	val rel: RepresentationRelationships = RepresentationRelationships()

}
