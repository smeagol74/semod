package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationFunctionElement, ApplicationFunctionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

case class ApplicationFunction(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationFunctionElement {

	case class ApplicationFunctionRelationships(
		private[archimate] implicit val tt: ApplicationFunction = ApplicationFunction.this
	) extends ApplicationFunctionElementRelationships[ApplicationFunction]

	val rel: ApplicationFunctionRelationships = ApplicationFunctionRelationships()

}
