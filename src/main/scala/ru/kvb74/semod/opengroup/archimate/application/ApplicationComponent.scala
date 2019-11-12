package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationComponentElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

case class ApplicationComponent(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationComponentElement {

	case class ApplicationComponentRelationships(
		override private[semod] implicit val tt: ApplicationComponent = ApplicationComponent.this
	) extends ApplicationComponentElementRelationships[ApplicationComponent]

	val rel: ApplicationComponentRelationships = ApplicationComponentRelationships()

	_registerPrefix("ACmp")
}
