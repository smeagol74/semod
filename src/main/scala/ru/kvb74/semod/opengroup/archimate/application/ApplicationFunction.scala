package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationFunctionElement, ApplicationFunctionElementProps, ApplicationFunctionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationFunction(
	name: String
) extends ApplicationLayer
	with ApplicationFunctionElement {

	case class ApplicationFunctionRelationships(
		override private[semod] implicit val tt: ApplicationFunction = ApplicationFunction.this
	) extends ApplicationFunctionElementRelationships[ApplicationFunction]

	val rel: ApplicationFunctionRelationships = ApplicationFunctionRelationships()

	case class ApplicationFunctionProps(
		override private[semod] implicit val tt: ApplicationFunction = ApplicationFunction.this
	) extends ApplicationFunctionElementProps[ApplicationFunction]

	val prop: ApplicationFunctionProps = ApplicationFunctionProps()

	_registerPrefix("AF")
}
