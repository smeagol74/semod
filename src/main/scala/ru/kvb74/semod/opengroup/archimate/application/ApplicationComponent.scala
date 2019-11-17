package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationComponentElement, ApplicationComponentElementProps, ApplicationComponentElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationComponent(
	name: String
) extends ApplicationLayer
	with ApplicationComponentElement {

	case class ApplicationComponentRelationships(
		override private[semod] implicit val tt: ApplicationComponent = ApplicationComponent.this
	) extends ApplicationComponentElementRelationships[ApplicationComponent]

	val rel: ApplicationComponentRelationships = ApplicationComponentRelationships()

	case class ApplicationComponentProps(
		override private[semod] implicit val tt: ApplicationComponent = ApplicationComponent.this
	) extends ApplicationComponentElementProps[ApplicationComponent]

	val prop: ApplicationComponentProps = ApplicationComponentProps()

	_registerPrefix("ACmp")
}
