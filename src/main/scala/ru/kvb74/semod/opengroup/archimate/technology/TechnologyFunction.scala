package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyFunctionElement, TechnologyFunctionElementProps, TechnologyFunctionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyFunction(
	name: String
) extends TechnologyLayer
	with TechnologyFunctionElement {

	case class TechnologyFunctionRelationships(
		override private[semod] implicit val tt: TechnologyFunction = TechnologyFunction.this
	) extends TechnologyFunctionElementRelationships[TechnologyFunction]

	val rel: TechnologyFunctionRelationships = TechnologyFunctionRelationships()

	case class TechnologyFunctionProps(
		override private[semod] implicit val tt: TechnologyFunction = TechnologyFunction.this
	) extends TechnologyFunctionElementProps[TechnologyFunction]

	val prop: TechnologyFunctionProps = TechnologyFunctionProps()

	_registerPrefix("TF")
}
