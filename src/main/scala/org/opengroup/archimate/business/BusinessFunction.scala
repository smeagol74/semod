package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessFunctionElement, BusinessFunctionElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessFunction(
	name: String,
	desc: String = ""
) extends Business
	with BusinessFunctionElement {

	case class BusinessFunctionRelationships(
		override private[archimate] implicit val tt: BusinessFunction = BusinessFunction.this
	) extends BusinessFunctionElementRelationships[BusinessFunction]

	val rel: BusinessFunctionRelationships = BusinessFunctionRelationships()

}
