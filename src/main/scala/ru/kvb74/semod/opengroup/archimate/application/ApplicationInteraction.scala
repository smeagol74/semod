package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationInteractionElement, ApplicationInteractionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationInteraction(
	name: String,
	desc: String = ""
) extends ApplicationLayer
	with ApplicationInteractionElement {

	case class ApplicationInteractionRelationships(
		override private[semod] implicit val tt: ApplicationInteraction = ApplicationInteraction.this
	) extends ApplicationInteractionElementRelationships[ApplicationInteraction]

	val rel: ApplicationInteractionRelationships = ApplicationInteractionRelationships()

	_registerPrefix("AI")
}
