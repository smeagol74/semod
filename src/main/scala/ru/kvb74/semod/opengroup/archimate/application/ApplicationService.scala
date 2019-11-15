package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationServiceElement, ApplicationServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationService(
	name: String,
	desc: String = ""
) extends ApplicationLayer
	with ApplicationServiceElement {

	case class ApplicationServiceRelationships(
		override private[semod] implicit val tt: ApplicationService = ApplicationService.this
	) extends ApplicationServiceElementRelationships[ApplicationService]

	val rel: ApplicationServiceRelationships = ApplicationServiceRelationships()

	_registerPrefix("AS")
}
