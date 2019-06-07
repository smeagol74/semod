package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationEventElement, ApplicationEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

case class ApplicationEvent(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationEventElement {

	case class ApplicationEventRelationships(
		private[archimate] implicit val tt: ApplicationEvent = ApplicationEvent.this
	) extends ApplicationEventElementRelationships[ApplicationEvent]

	val rel: ApplicationEventRelationships = ApplicationEventRelationships()

}
