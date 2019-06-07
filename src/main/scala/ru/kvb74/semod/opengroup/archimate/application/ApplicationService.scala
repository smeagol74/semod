package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationServiceElement, ApplicationServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

case class ApplicationService(
	name: String,
	desc: String = ""
) extends Application
	with ApplicationServiceElement {

	case class ApplicationServiceRelationships(
		private[archimate] implicit val tt: ApplicationService = ApplicationService.this
	) extends ApplicationServiceElementRelationships[ApplicationService]

	val rel: ApplicationServiceRelationships = ApplicationServiceRelationships()

}
