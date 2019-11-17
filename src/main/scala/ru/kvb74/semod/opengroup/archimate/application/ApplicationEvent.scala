package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationEventElement, ApplicationEventElementProps, ApplicationEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationEvent(
	name: String
) extends ApplicationLayer
	with ApplicationEventElement {

	case class ApplicationEventRelationships(
		override private[semod] implicit val tt: ApplicationEvent = ApplicationEvent.this
	) extends ApplicationEventElementRelationships[ApplicationEvent]

	val rel: ApplicationEventRelationships = ApplicationEventRelationships()

	case class ApplicationEventProps(
		override private[semod] implicit val tt: ApplicationEvent = ApplicationEvent.this
	) extends ApplicationEventElementProps[ApplicationEvent]

	val prop: ApplicationEventProps = ApplicationEventProps()

	_registerPrefix("AE")
}
