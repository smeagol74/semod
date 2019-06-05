package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessActorElement, BusinessActorElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessActor(
	name: String,
	desc: String = ""
) extends Business
	with BusinessActorElement {

	case class BusinessActorRelationships(
		private[archimate] implicit val tt: BusinessActor = BusinessActor.this
	) extends BusinessActorElementRelationships[BusinessActor]

	val rel: BusinessActorRelationships = BusinessActorRelationships()

}
