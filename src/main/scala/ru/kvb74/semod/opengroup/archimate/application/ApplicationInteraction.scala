package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationInteractionElement, ApplicationInteractionElementProps, ApplicationInteractionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationInteraction(
	name: String
) extends ApplicationLayer
	with ApplicationInteractionElement {

	case class ApplicationInteractionRelationships(
		override private[semod] implicit val tt: ApplicationInteraction = ApplicationInteraction.this
	) extends ApplicationInteractionElementRelationships[ApplicationInteraction]

	val rel: ApplicationInteractionRelationships = ApplicationInteractionRelationships()

	case class ApplicationInteractionProps(
		override private[semod] implicit val tt: ApplicationInteraction = ApplicationInteraction.this
	) extends ApplicationInteractionElementProps[ApplicationInteraction]

	val prop: ApplicationInteractionProps = ApplicationInteractionProps()

	_registerPrefix("AI")
}
