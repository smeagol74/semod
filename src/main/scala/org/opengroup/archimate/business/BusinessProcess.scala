package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessProcessElement, BusinessProcessElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessProcess(
	name: String,
	desc: String = ""
) extends Business
	with BusinessProcessElement {

	object rel extends BusinessProcessElementRelationships[BusinessProcess] {
		override private[archimate] implicit val tt: BusinessProcess = BusinessProcess.this
	}

}
