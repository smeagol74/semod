package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationProcessElement, ApplicationProcessElementProps, ApplicationProcessElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class ApplicationProcess(
	name: String
) extends ApplicationLayer
	with ApplicationProcessElement {

	case class ApplicationProcessRelationships(
		override private[semod] implicit val tt: ApplicationProcess = ApplicationProcess.this
	) extends ApplicationProcessElementRelationships[ApplicationProcess]

	val rel: ApplicationProcessRelationships = ApplicationProcessRelationships()

	case class ApplicationProcessProps(
		override private[semod] implicit val tt: ApplicationProcess = ApplicationProcess.this
	) extends ApplicationProcessElementProps[ApplicationProcess]

	val prop: ApplicationProcessProps = ApplicationProcessProps()

	_registerPrefix("AP")
}
