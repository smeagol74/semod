package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationServiceElement, ApplicationServiceElementProps, ApplicationServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationService(
	name: String
) extends ApplicationLayer
	with ApplicationServiceElement {

	case class ApplicationServiceRelationships(
		override private[semod] implicit val tt: ApplicationService = ApplicationService.this
	) extends ApplicationServiceElementRelationships[ApplicationService]

	val rel: ApplicationServiceRelationships = ApplicationServiceRelationships()

	case class ApplicationServiceProps(
		override private[semod] implicit val tt: ApplicationService = ApplicationService.this
	) extends ApplicationServiceElementProps[ApplicationService]

	val prop: ApplicationServiceProps = ApplicationServiceProps()

	_registerPrefix("AS")
}
