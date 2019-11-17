package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyProcessElement, TechnologyProcessElementProps, TechnologyProcessElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyProcess(
	name: String
) extends TechnologyLayer
	with TechnologyProcessElement {

	case class TechnologyProcessRelationships(
		override private[semod] implicit val tt: TechnologyProcess = TechnologyProcess.this
	) extends TechnologyProcessElementRelationships[TechnologyProcess]

	val rel: TechnologyProcessRelationships = TechnologyProcessRelationships()

	case class TechnologyProcessProps(
		override private[semod] implicit val tt: TechnologyProcess = TechnologyProcess.this
	) extends TechnologyProcessElementProps[TechnologyProcess]

	val prop: TechnologyProcessProps = TechnologyProcessProps()

	_registerPrefix("TP")
}
