package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationInterfaceElement, ApplicationInterfaceElementProps, ApplicationInterfaceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationInterface(
	name: String
) extends ApplicationLayer
	with ApplicationInterfaceElement {

	case class ApplicationInterfaceRelationships(
		override private[semod] implicit val tt: ApplicationInterface = ApplicationInterface.this
	) extends ApplicationInterfaceElementRelationships[ApplicationInterface]

	val rel: ApplicationInterfaceRelationships = ApplicationInterfaceRelationships()

	case class ApplicationInterfaceProps(
		override private[semod] implicit val tt: ApplicationInterface = ApplicationInterface.this
	) extends ApplicationInterfaceElementProps[ApplicationInterface]

	val prop: ApplicationInterfaceProps = ApplicationInterfaceProps()

	_registerPrefix("AIf")
}
