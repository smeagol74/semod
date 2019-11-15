package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyFunctionElement, TechnologyFunctionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyFunction(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with TechnologyFunctionElement {

	case class TechnologyFunctionRelationships(
		override private[semod] implicit val tt: TechnologyFunction = TechnologyFunction.this
	) extends TechnologyFunctionElementRelationships[TechnologyFunction]

	val rel: TechnologyFunctionRelationships = TechnologyFunctionRelationships()

	_registerPrefix("TF")
}
