package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationInterfaceElement, ApplicationInterfaceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

case class ApplicationInterface(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationInterfaceElement {

	case class ApplicationInterfaceRelationships(
		override private[archimate] implicit val tt: ApplicationInterface = ApplicationInterface.this
	) extends ApplicationInterfaceElementRelationships[ApplicationInterface]

	val rel: ApplicationInterfaceRelationships = ApplicationInterfaceRelationships()

}
