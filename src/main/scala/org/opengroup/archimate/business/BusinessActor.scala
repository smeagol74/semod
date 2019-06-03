package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessActorElement, BusinessActorElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessActor(
	name: String,
	desc: String = ""
) extends Business
	with BusinessActorElement {

	object rel extends BusinessActorElementRelationships[BusinessActor] {
		override private[archimate] implicit val tt: BusinessActor = BusinessActor.this
	}

}
